package com.example.marvelexamen;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    Context mContext;
    List<Article> mArticles = new ArrayList<>();

    public MyAdapter(Context mContext, List<Article> mArticles) {
        this.mContext = mContext;
        this.mArticles = mArticles;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(mArticles.get(position).getUrlToImage())
                .fit()
                .centerCrop()
                .into(holder.imagePelicula);
        holder.tituloPelicula.setText(mArticles.get(position).getTitle());
        if(mArticles.get(position).getDescription().length() <= 100){
            holder.descPelicula.setText(mArticles.get(position).getDescription());
        }
        else{
            holder.descPelicula.setText(mArticles.get(position).getDescription().substring(0,100) + "...");
        }

        holder.fechaPelicula.setText(mArticles.get(position).getPublishedAt());
        holder.clickDetail.setOnClickListener(view -> {
            Intent i = new Intent(mContext,DetailActivity.class);
            i.putExtra("articulo",(Serializable) mArticles.get(position));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            mContext.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagePelicula;
        private TextView tituloPelicula,descPelicula,fechaPelicula;
        private LinearLayout clickDetail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePelicula = itemView.findViewById(R.id.imagePelicula);
            tituloPelicula = itemView.findViewById(R.id.tituloPelicula);
            descPelicula = itemView.findViewById(R.id.descPelicula);
            fechaPelicula = itemView.findViewById(R.id.fechaReview);
            clickDetail = itemView.findViewById(R.id.clickDetail);

        }
    }
}
