package com.example.wartawanapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wartawanapp.R;

public class InputBeritaActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView image;
    EditText etjudul, ettanggal, ettkp,ettags, etdeskripsi;
    ImageButton btnpublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputberita);

        image = findViewById(R.id.image);
        etjudul = findViewById(R.id.etjudul);
        ettanggal = findViewById(R.id.ettanggal);
        ettkp = findViewById(R.id.ettkp);
        ettags = findViewById(R.id.ettags);
        etdeskripsi = findViewById(R.id.etdeskripsi);
        btnpublish = findViewById(R.id.btnpublish);
        btnpublish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }

    }
}