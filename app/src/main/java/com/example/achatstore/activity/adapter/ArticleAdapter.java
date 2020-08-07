package com.example.achatstore.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.achatstore.R;
import com.example.achatstore.bo.Article;

import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(@NonNull Context context, int resource, @NonNull List<Article> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View nouvelleLigne, @NonNull ViewGroup parent) {
        if(nouvelleLigne == null){
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            nouvelleLigne = li.inflate(R.layout.style_article_list, parent, false);
        }

        TextView tvNom = nouvelleLigne.findViewById(R.id.tv_nom);
        TextView tvPrix = nouvelleLigne.findViewById(R.id.tv_prix);
        tvNom.setText(getItem(position).getNom());
        tvPrix.setText(String.valueOf(getItem(position).getPrix()));

        return nouvelleLigne;
    }
}//end
