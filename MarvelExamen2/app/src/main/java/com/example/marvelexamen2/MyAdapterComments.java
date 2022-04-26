package com.example.marvelexamen2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterComments extends RecyclerView.Adapter<MyAdapterComments.MyViewHolder>{

    Context mContext;
    ArrayList<String> mComments = new ArrayList<>();

    public MyAdapterComments(Context mContext, ArrayList<String> mComments) {
        this.mContext = mContext;
        this.mComments = mComments;
    }

    @NonNull
    @Override
    public MyAdapterComments.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_row_comments, parent, false);
        return new MyAdapterComments.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterComments.MyViewHolder holder, int position) {
        holder.comment.setText(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView comment;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            comment = itemView.findViewById(R.id.comment);
        }
    }
}
