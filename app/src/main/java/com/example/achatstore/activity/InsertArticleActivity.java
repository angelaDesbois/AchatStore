package com.example.achatstore.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.achatstore.R;
import com.example.achatstore.bo.Article;
import com.example.achatstore.repository.ArticleBddRepository;
import com.example.achatstore.repository.IArticleRepository;
import com.facebook.stetho.Stetho;

public class InsertArticleActivity extends AppCompatActivity {
   @Override
    protected void onCreate(Bundle savedInstancesState) {
       Stetho.initializeWithDefaults(this);

       super.onCreate(savedInstancesState);
       setContentView(R.layout.activity_insert_article);
   }

    public void onClickSaveWololo(View view) {

        IArticleRepository repo = new ArticleBddRepository(this);

        EditText etNomArticle = findViewById(R.id.et_nom_article);
        EditText etPrixArticle = findViewById(R.id.et_prix_article);
        EditText etDescription = findViewById(R.id.et_description_article);
        EditText etNote = findViewById(R.id.et_note_article);
        EditText etLien = findViewById(R.id.et_lien_article);

        String nom = etNomArticle.getText().toString();
        float prix = Float.parseFloat(etPrixArticle.getText().toString());
        String description = etDescription.getText().toString();
        int note = Integer.parseInt(etNote.getText().toString());
        String lien = etLien.getText().toString();



        Article item1 = new Article(0,nom, false, prix, description, note, lien);
        repo.insert(item1);

        Toast.makeText(this, "Info : " + item1, Toast.LENGTH_LONG).show();


    }
}
