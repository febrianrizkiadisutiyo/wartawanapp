package com.example.wartawanapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wartawanapp.R;
import com.example.wartawanapp.activity.Adapter.AdapterData;
import com.example.wartawanapp.api.ApiClient;
import com.example.wartawanapp.api.ApiInterface;
import com.example.wartawanapp.model.tampilanberita.DataBerita;
import com.example.wartawanapp.model.tampilanberita.TampilanData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilanBerita extends AppCompatActivity {
    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private List<DataBerita> ListData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_berita);

        rvData = findViewById(R.id.rv_list);
        RecyclerView.LayoutManager lmData = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        retrieveData();
    }

    public void retrieveData() {
        ApiInterface ardData = ApiClient.getClient().create(ApiInterface.class);
        Call<TampilanData> tampilData = ardData.TampilanResponse();

        tampilData.enqueue(new Callback<TampilanData>() {
            @Override
            public void onResponse(@NonNull Call<TampilanData> call, @NonNull Response<TampilanData> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();
                Toast.makeText(TampilanBerita.this, "Kode :" + kode + " | pesan :" + pesan, Toast.LENGTH_SHORT).show();
                ListData = response.body().getData();
                adData = new AdapterData(TampilanBerita.this, ListData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<TampilanData> call, @NonNull Throwable t) {
                Toast.makeText(TampilanBerita.this, "gagal terhubung", Toast.LENGTH_SHORT).show();
            }
        });
    }
}