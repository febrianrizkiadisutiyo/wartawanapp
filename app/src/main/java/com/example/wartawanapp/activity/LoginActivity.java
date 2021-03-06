package com.example.wartawanapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wartawanapp.R;
import com.example.wartawanapp.api.ApiClient;
import com.example.wartawanapp.api.ApiInterface;
import com.example.wartawanapp.model.login.Login;
import com.example.wartawanapp.model.login.LoginData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etid, etpassword;
    ImageButton btnlogin;
    TextView tvregister;
    String idWartawan, Password;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);

        etid = findViewById(R.id.etid);
        etpassword = findViewById(R.id.etpassword);

        btnlogin = findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);

        tvregister = findViewById(R.id.tvregister);
        tvregister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnlogin:
                idWartawan = etid.getText().toString();
                Password = etpassword.getText().toString();
                login(idWartawan, Password);
                break;
            case R.id.tvregister:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void login(String idWartawan, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.LoginResponse(idWartawan, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(@NonNull Call<Login> call, @NonNull Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {

                    sessionManager = new SessionManager(LoginActivity.this);
                    LoginData loginData = response.body().getData();
                    sessionManager.createLoginSession(loginData);

                    Toast.makeText(LoginActivity.this, response.body().getData().getNamaLengkap(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<Login> call, @NonNull Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
