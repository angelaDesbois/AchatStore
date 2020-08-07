package com.example.achatstore.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.achatstore.bo.Article;
import com.example.achatstore.repository.ArticleBddRepository;
import com.example.achatstore.repository.IArticleRepository;

import java.util.List;

public class ArticleViewModel extends AndroidViewModel {
    private IArticleRepository repo;
    private LiveData<List<Article>> observateur = null;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        repo = new ArticleBddRepository(application);
        observateur = repo.get();
    }

    public LiveData<List<Article>> get(){
        return observateur;
    }

    public void insert(Article article){
        repo.insert(article);
    }

    public void update(Article article){
        repo.update(article);
    }

    public void delete(Article article){
        repo.delete(article);
    }

 /*  *//* public void delete(){
        repo.delete();*//*
    }*/
}
