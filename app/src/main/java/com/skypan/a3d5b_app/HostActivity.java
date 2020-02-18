package com.skypan.a3d5b_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HostActivity extends AppCompatActivity {

    private Button btnBack;
    private Button btnDisjoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HostActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnDisjoin = findViewById(R.id.btn_disjoin);
        btnDisjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HostActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
