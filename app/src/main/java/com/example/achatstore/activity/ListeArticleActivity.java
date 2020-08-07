package com.example.achatstore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.achatstore.R;
import com.example.achatstore.activity.adapter.ArticleAdapter;
import com.example.achatstore.bo.Article;
import com.example.achatstore.view_model.ArticleViewModel;

import java.util.List;

public class ListeArticleActivity extends AppCompatActivity {
    private ListView maListe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_article);

        //pr listener
        maListe = findViewById(R.id.list_article);
        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

             Article article = (Article) maListe.getAdapter().getItem(position);
             Intent intent = new Intent(ListeArticleActivity.this,ArticleDetailActivity.class );
             intent.putExtra("cle", article );
             startActivity(intent);


                Toast.makeText(ListeArticleActivity.this, "heehoho" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArticleViewModel vm = ViewModelProviders.of(this).get(ArticleViewModel.class);
        LiveData<List<Article>> observateur = vm.get();

        observateur.observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
             //   ListView maListe = findViewById(R.id.list_article);
                ArticleAdapter adapter = new ArticleAdapter(ListeArticleActivity.this, R.layout.style_article_list, articles);
                maListe.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}//end