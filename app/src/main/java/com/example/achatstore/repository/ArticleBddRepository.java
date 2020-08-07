package com.example.achatstore.repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import com.example.achatstore.bo.Article;
import com.example.achatstore.dal.AppDatabase;
import com.example.achatstore.dal.ArticleDao;

import java.util.List;

public class ArticleBddRepository implements  IArticleRepository{

    private ArticleDao articleDao = null;

    public ArticleBddRepository(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        articleDao = db.getArticleDao();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void insert(Article article) {
        new AsyncTask<Article, Void, Void>() {


            @Override
            protected Void doInBackground(Article... articles) {
                //insertion d un article ds la bdd
                articleDao.insert(articles[0]);
                return null;
            }
        }.execute(article);
    }

    List<Article> resultat = null;
    @Override
    public LiveData<List<Article>> get() {
        return  articleDao.get();
    }

    @Override
    public LiveData<Article> get(int id) {
        return null;
    }

    @Override
    public void update(Article article) {
        new AsyncTask<Article, Void, Void>() {


            @Override
            protected Void doInBackground(Article... articles) {
                articleDao.update(articles[0]);
                return null;
            }
        }.execute(article);
    }

    @Override
    public void delete(final Article article) {
        new AsyncTask<Article, Void, Void>() {


            @Override
            protected Void doInBackground(Article... articles) {
                articleDao.delete(articles[0]);
                return null;
            }
        }.execute(article);
    }

   /* @Override
    public void delete() {
        articleDao.delete();
        return null;

    }*/

}

