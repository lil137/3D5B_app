package com.skypan.a3d5b_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchResultActivity extends AppCompatActivity {

    private TextView tv_singer;
    private DatabaseReference mReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);


        tv_singer = findViewById(R.id.tv_1);
        Intent intent = getIntent();
        String keyword = intent.getStringExtra("keyword");

        //tv_singer.setText(keyword);
        displayData(keyword);

    }

    private void displayData(String keyword) {
        mReference = FirebaseDatabase.getInstance().getReference("singers");
        //DatabaseReference singer = mReference.child("singers");

        mReference.orderByKey().equalTo(keyword).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String post = dataSnapshot.getValue(String.class);
                if( post == null){
                    Toast.makeText(SearchResultActivity.this, "No results found", Toast.LENGTH_SHORT).show();
                }

                tv_singer.setText("singer：" + post);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}


