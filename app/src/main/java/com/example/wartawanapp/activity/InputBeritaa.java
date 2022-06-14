package com.example.wartawanapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wartawanapp.R;
import com.example.wartawanapp.api.ApiClient;
import com.example.wartawanapp.api.ApiInterface;

public class InputBeritaa extends AppCompatActivity {

    Button btn;


    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_beritaa);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

       btn = findViewById(R.id.btn);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(InputBeritaa.this, "tets", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(InputBeritaa.this, MainActivity.class);
               startActivity(intent);

           }
       });

    }
}