package com.example.musicappjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Cd> cds;
    private Context mContext;
    public MyAdapter(ArrayList<Cd> cds, Context mContext){
        this.cds = cds;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.recyclerview1,parent,false);
        return new MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(cds.get(position).getImageCD())            .fit()            .centerCrop()            .into(holder.imageView);
        holder.textType.setText(cds.get(position).getNameCD());
    }

    @Override
    public int getItemCount() {
        return cds.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView2;
        private ImageView imageView;
        private TextView textType;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img1);
            textType = itemView.findViewById(R.id.textView);
        }
    }
}
