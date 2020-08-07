package com.example.achatstore.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.achatstore.R;
import com.example.achatstore.bo.Article;
import com.example.achatstore.repository.ArticleBddRepository;
import com.example.achatstore.repository.IArticleRepository;
import com.facebook.stetho.Stetho;

public class ArticleDetailActivity extends AppCompatActivity {
    private Article article = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Stetho.initializeWithDefaults(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        Intent intent = getIntent();
        article = intent.getParcelableExtra("cle");

        TextView tvNom = findViewById(R.id.tv_nom);
        tvNom.setText(article.getNom());

        TextView tvPrix = findViewById(R.id.tv_prix);
        tvPrix.setText(String.valueOf(article.getPrix()));

        TextView tvDescription = findViewById(R.id.tv_description);
        tvDescription.setText(article.getDescription());

        TextView tvLien = findViewById(R.id.tv_lien);
        tvLien.setText(article.getLien());


    }


    public void onClickUpdate(View view) {
        // si plusieurs new intent changer name
        //si clik -> go sur la page articleupdate   
        Intent intentUpdate = new Intent(this, ArticleUpdateActivity.class);
        intentUpdate.putExtra("clé", article);
        startActivity(intentUpdate);


    }

    public void onClickDelete(View view) {

        IArticleRepository repo = new ArticleBddRepository(this);


        repo.delete(article);
        Intent intent = new Intent(this,ListeArticleActivity.class );
        startActivity(intent);




    }
}









