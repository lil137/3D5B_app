package com.skypan.a3d5b_app;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.skypan.a3d5b_app.Connectors.UserService;
import com.skypan.a3d5b_app.Model.User;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;


public class tempActivity extends AppCompatActivity {

    private TextView tv_singer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_temp);

        tv_singer = findViewById(R.id.tv_1);

        //Intent intent = getIntent();
        //String keyword = intent.getStringExtra("keyword");


        //displayResult(keyword);


    }

    private void displayResult(String keyword){
        tv_singer.setText(keyword);
    }


}


