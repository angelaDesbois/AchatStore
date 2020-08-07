package com.example.achatstore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.InvalidationTracker;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.achatstore.R;
import com.example.achatstore.bo.Article;
import com.example.achatstore.repository.ArticleBddRepository;
import com.example.achatstore.repository.IArticleRepository;
import com.example.achatstore.view_model.ArticleViewModel;
import com.facebook.stetho.Stetho;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context = null;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_main);

        IArticleRepository repoArticle = new ArticleBddRepository(this);
        ArticleViewModel vm = ViewModelProviders.of(this).get(ArticleViewModel.class);

       // Article articleUn = new Article(0, "sourisWiFi", false, 12.55f, "au top", 4, "www.google.com");
        //repoArticle.insert(articleUn);
        LiveData<List<Article>> observateur = vm.get();

        observateur.observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                for (Article article : articles){
                    Log.i("lalala", "ARTICLE: "+ article);
            }
        }
        });
    }
}