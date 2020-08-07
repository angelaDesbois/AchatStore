package com.example.achatstore.dal;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.achatstore.bo.Article;

import java.util.List;

/**
 * pr que Room puisse créer la DAO pr la table Article
 */
@Dao
public interface ArticleDao {
    @Insert
    void insert(Article article);

    @Insert
    void insert(Article ... articles);

    @Query("SELECT * FROM Article")
   LiveData<List<Article>> get();

    @Query("SELECT * FROM Article WHERE id = :id")
    Article get(int id);

    @Update
    void update(Article article);

    @Delete
    void delete(Article article);

 /*   @Query("DELETE FROM Article")
    void delete();*/
}
