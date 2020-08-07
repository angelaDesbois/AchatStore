package com.example.achatstore.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.achatstore.R;

public class MenuIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_intent);
    }

    public void onClickmainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickmainInsert(View view) {
        Intent intent = new Intent(this, InsertArticleActivity.class);
        startActivity(intent);
    }

    public void onClickmainlist(View view) {
        Intent intent = new Intent(this, ListeArticleActivity.class);
        startActivity(intent);
    }

}//end