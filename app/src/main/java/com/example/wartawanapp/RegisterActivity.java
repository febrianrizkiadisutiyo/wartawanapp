package com.example.wartawanapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wartawanapp.api.ApiClient;
import com.example.wartawanapp.api.ApiInterface;
import com.example.wartawanapp.model.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etid,etpassword,etnama,etemail,etnohp,etjkelamin;
    ImageButton btnregister;
    String idWartawan,Password,Nama,Email,noHp,jenisKelamin;
    ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        etid = findViewById(R.id.etid);
        etpassword = findViewById(R.id.etpassword);
        etnama = findViewById(R.id.etnama);
        etemail = findViewById(R.id.etemail);
        etnohp = findViewById(R.id.etnohp);
        etjkelamin = findViewById(R.id.etjkelamin);

        btnregister = findViewById(R.id.btnregister);
        btnregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnregister:
                idWartawan = etid.getText().toString();
                Password = etpassword.getText().toString();
                Nama = etnama.getText().toString();
                Email = etemail.getText().toString();
                noHp = etnohp.getText().toString();
                jenisKelamin = etjkelamin.getText().toString();
                register(idWartawan,Password,Nama,Email,noHp,jenisKelamin);
        }
    }

    private void register(String idWartawan, String password, String nama, String email, String noHp, String jenisKelamin) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Register> call = apiInterface.RegisterResponse(idWartawan, password, nama, email, noHp, jenisKelamin);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
