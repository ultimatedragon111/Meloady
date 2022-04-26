package com.example.musicappjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.compose.animation.core.Animation;
import androidx.core.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder>{
    private ArrayList<Song> songs;
    private Context mContext;
    public MyAdapter2(ArrayList<Song> songs, Context mContext){
        this.songs = songs;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recycleview2,parent,false);
        return new MyAdapter2.MyViewHolder(view) ;
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, int position) {
        Picasso.get().load(songs.get(position).getBandSong())            .fit()            .centerCrop()            .into(holder.imageView2);
        holder.textType2.setText(songs.get(position).getNameSong());
        holder.textType3.setText(songs.get(position).getImageSong());
        holder.imageView3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                
            }
        });


    }
    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView2;
        private TextView textType2;
        private TextView textType3;
        private ImageView imageView3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView2 = itemView.findViewById(R.id.imageView2);
            textType2 = itemView.findViewById(R.id.textView2);
            textType3 = itemView.findViewById(R.id.textView3);
            imageView3 = itemView.findViewById(R.id.imageView3);
        }
    }
}
