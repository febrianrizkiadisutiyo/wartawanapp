package com.example.wartawanapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wartawanapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView etid,etnama;
    Button btnpindah;
    SessionManager sessionManager;
    String id_wartawan, nama_lengkap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()) {
            moveToLogin();
        }
        etid = findViewById(R.id.etid);
        etnama = findViewById(R.id.etnama);

        btnpindah = findViewById(R.id.btnpindah);
        btnpindah.setOnClickListener(this);

        id_wartawan = sessionManager.getUserDetail().get(SessionManager.id_wartawan);
        nama_lengkap = sessionManager.getUserDetail().get(SessionManager.nama_lengkap);

        etid.setText(id_wartawan);
        etnama.setText(nama_lengkap);

    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionlogout:
                sessionManager.logoutSession();
                moveToLogin();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,ProfilActivity.class);
        startActivity(intent);
        finish();
    }
}