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

    private void displayData(final String keyword) {
        mReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference singer = mReference.child("singers");

        singer.orderByValue().equalTo("Drake").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String data_key = dataSnapshot.getKey();
                String data_val = dataSnapshot.getValue(String.class);
                if( data_val == null){
                    Toast.makeText(SearchResultActivity.this, "No results found", Toast.LENGTH_SHORT).show();
                }
                    tv_singer.setText("singer：" + data_val);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}


