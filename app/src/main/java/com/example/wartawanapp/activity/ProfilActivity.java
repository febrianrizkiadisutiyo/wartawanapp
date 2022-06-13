package com.example.wartawanapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wartawanapp.R;

public class ProfilActivity extends AppCompatActivity {

    EditText etnama, etid, etemail,etnohp,etjk;
    String nama_lengkap, id_wartawan, email, no_hp,jenis_kelamin;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

        sessionManager = new SessionManager(ProfilActivity.this);
        if(!sessionManager.isLoggedIn()){
        }

        etnama = findViewById(R.id.etnama);
        etid = findViewById(R.id.etid);
        etemail = findViewById(R.id.etemail);
        etnohp = findViewById(R.id.etnohp);
        etjk = findViewById(R.id.etjk);

        nama_lengkap = sessionManager.getUserDetail().get(SessionManager.nama_lengkap);
        etnama.setText(nama_lengkap);

        id_wartawan = sessionManager.getUserDetail().get(SessionManager.id_wartawan);
        etid.setText(id_wartawan);

        email = sessionManager.getUserDetail().get(SessionManager.email);
        etemail.setText(email);

        no_hp = sessionManager.getUserDetail().get(SessionManager.no_hp);
        etnohp.setText(no_hp);

        jenis_kelamin = sessionManager.getUserDetail().get(SessionManager.jenis_kelamin);
        etjk.setText(jenis_kelamin);
    }

}
