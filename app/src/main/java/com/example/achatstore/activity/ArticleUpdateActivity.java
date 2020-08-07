package com.example.achatstore.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.achatstore.R;
import com.example.achatstore.bo.Article;
import com.example.achatstore.repository.ArticleBddRepository;
import com.example.achatstore.repository.IArticleRepository;
import com.facebook.stetho.Stetho;

public class ArticleUpdateActivity extends AppCompatActivity {
    //global pr eviter des intent partout
    private Article article = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Stetho.initializeWithDefaults(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_update);

        Intent intent = getIntent();
        article = intent.getParcelableExtra("clé");

        EditText etNom = findViewById(R.id.et_nom_article);
        etNom.setText(article.getNom());

        EditText etPrix = findViewById(R.id.et_prix_article);
        etPrix.setText(String.valueOf(article.getPrix()));

        EditText etDescription = findViewById(R.id.et_description_article);
        etDescription.setText(article.getDescription());

        EditText etLien = findViewById(R.id.et_lien_article);
        etLien.setText(article.getLien());

        EditText etNote = findViewById(R.id.et_note_article);
        etNote.setText(article.getLien());

    }

    public void onClickSaveUpdate(View view) {

        IArticleRepository repo = new ArticleBddRepository(this);

        EditText etNom = findViewById(R.id.et_nom_article);
        article.setNom(etNom.getText().toString());

        EditText etPrix = findViewById(R.id.et_prix_article);
        article.setPrix(Float.parseFloat(etPrix.getText().toString()));

        EditText etDescription = findViewById(R.id.et_description_article);
        article.setDescription(etDescription.getText().toString());

        EditText etLien = findViewById(R.id.et_lien_article);
        article.setLien(etLien.getText().toString());

        EditText etNote = findViewById(R.id.et_note_article);
        article.setNote(Integer.parseInt(etNote.getText().toString()));



        repo.update(article);

    //permet de retourner a la page que l on veut
        Intent intent = new Intent(this,ListeArticleActivity.class );
        startActivity(intent);


    }
}