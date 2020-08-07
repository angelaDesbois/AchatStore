package com.example.achatstore.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.achatstore.bo.Article;

@Database(entities = {Article.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE = null;

    public abstract  ArticleDao getArticleDao();

    //definir singleton
    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "mySecondApp.db").build();
        }
        return INSTANCE;
    }
}
