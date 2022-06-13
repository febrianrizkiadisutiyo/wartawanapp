package com.example.wartawanapp.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

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
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image:
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

        }

    }
}