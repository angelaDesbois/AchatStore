package com.example.achatstore.repository;

import androidx.lifecycle.LiveData;

import com.example.achatstore.bo.Article;

import java.util.List;

/**
 * interface permettant de mettre en place le design pattern DAO
 */
public interface IArticleRepository {

    void insert(Article article);
    LiveData<List<Article>> get();

    LiveData<Article> get(int id);

    void update(Article article);

    void delete(Article article);

   // void delete();


}
