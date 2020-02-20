package com.skypan.a3d5b_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private TextView mPopularUnderline;
    private Button mBtnSearch;
    private EditText mETsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mPopularUnderline = findViewById(R.id.tv_popular);
        mBtnSearch = findViewById(R.id.btn_search);
        mETsearch = findViewById(R.id.et_search);

        mETsearch.setText("");


        mPopularUnderline.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        mPopularUnderline.getPaint().setAntiAlias(true);


        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText=mETsearch.getText().toString();
                //Toast.makeText(SearchActivity.this, inputText, Toast.LENGTH_SHORT).show();

                if( inputText.length() == 0){
                    //Toast.makeText(SearchActivity.this, "Please enter the things you want to search", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder dialog = new AlertDialog.Builder(SearchActivity.this);
                    dialog.setTitle("Tips");
                    dialog.setMessage("Please enter the things you want to search");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.setNegativeButton("", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();



                }else {
                    Intent intent = new Intent(SearchActivity.this, SearchResultActivity.class);
                    intent.putExtra("keyword",inputText);
                    startActivity(intent);
                }
            }
        });
    }
}
