package com.example.wartawanapp.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import com.example.wartawanapp.R;
import com.example.wartawanapp.api.ApiClient;
import com.example.wartawanapp.api.ApiInterface;
import com.example.wartawanapp.model.inputberita.InputBerita;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Multipart;

public class InputBeritaActivity extends AppCompatActivity {

    ImageView image;
    EditText etjudul, ettanggal, ettkp,ettags, etdeskripsi;
    ImageButton btnpublish, btndraft;
    TextView logout;
    String path;

    Button btntest;

    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputberita);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        image = findViewById(R.id.image);
        etjudul = findViewById(R.id.etjudul);
        ettanggal = findViewById(R.id.ettanggal);
        ettkp = findViewById(R.id.ettkp);
        ettags = findViewById(R.id.ettags);
        etdeskripsi = findViewById(R.id.etdeskripsi);
        btnpublish = findViewById(R.id.btnpublish);
        btndraft = findViewById(R.id.btndraft);
        btntest = findViewById(R.id.btntest);
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publish();
                Toast.makeText(InputBeritaActivity.this, "this ", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(InputBeritaActivity.this,ProfilActivity.class);
//                startActivity(intent);
            }
        });
        btndraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InputBeritaActivity.this, "testes", Toast.LENGTH_SHORT).show();
            }
        });

        logout = findViewById(R.id.logout);

        image.setOnClickListener(v->{
            if(ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 10);
            } else {
                ActivityCompat.requestPermissions(InputBeritaActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }
        });

//        btnpublish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(InputBeritaActivity.this, "test", Toast.LENGTH_SHORT).show();
//                publish();
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = InputBeritaActivity.this;
            path = RealPathUtil.getRealPath(context, uri);
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            image.setImageBitmap(bitmap);
        }
    }

    private void publish() {
        String judul, tanggal, tkp, tags, deskripsi;
        judul = etjudul.getText().toString();
        tanggal = ettanggal.getText().toString();
        tkp = ettkp.getText().toString();
        tags = ettags.getText().toString();
        deskripsi = etdeskripsi.getText().toString();

        if (path == null){
            Toast.makeText(this, "Mohon upload image", Toast.LENGTH_SHORT).show();
            return;
        }

        File file = new File(path);
        RequestBody requetFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part bodyimg = MultipartBody.Part.createFormData("gambar",file.getName(),requetFile);
        RequestBody requestjudul = RequestBody.create(MediaType.parse("multipart/form-data"), judul);
        RequestBody requesttanggal = RequestBody.create(MediaType.parse("multipart/form-data"), tanggal);
        RequestBody requesttkp = RequestBody.create(MediaType.parse("multipart/form-data"), tkp);
        RequestBody requesttags = RequestBody.create(MediaType.parse("multipart/form-data"), tags);
        RequestBody requestdeskripsi = RequestBody.create(MediaType.parse("multipart/form-data"), deskripsi);

        apiInterface.InputBeritaResponse(
                bodyimg,
                requestjudul,
                requesttanggal,
                requesttkp,
                requesttags,
                requestdeskripsi
        ).enqueue(new Callback<InputBerita>() {
            @Override
            public void onResponse(Call<InputBerita> call, Response<InputBerita> response) {
                if(response.isSuccessful()){
                    if(response.body() != null);
                        String status = response.body().getStatus();
                        String message = response.body().getMessage();
                    if (status.equals("success")){
                        Toast.makeText(InputBeritaActivity.this, "Success, "+ message, Toast.LENGTH_SHORT).show();

                         //Mengirim user ke activity login
                        Intent intent = new Intent(InputBeritaActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(InputBeritaActivity.this, message , Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(InputBeritaActivity.this, "Data null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InputBerita> call, Throwable t) {
                Toast.makeText(InputBeritaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }






}