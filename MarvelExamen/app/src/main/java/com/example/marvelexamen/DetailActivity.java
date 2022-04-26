package com.example.marvelexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    Article article;
    private ImageView imageDetail;
    private TextView titleDetail,fechaDetail,descriptionDetail,contentDetail,nameDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        article = (Article) getIntent().getExtras().getSerializable("article");

        imageDetail = findViewById(R.id.imageDetail);
        titleDetail = findViewById(R.id.titleDetail);
        fechaDetail = findViewById(R.id.fechaDetail);
        descriptionDetail = findViewById(R.id.descriptionDetail);
        contentDetail = findViewById(R.id.contentDetail);
        nameDetail = findViewById(R.id.nameDetail);

        Picasso.get().load(article.getUrlToImage())
                .fit()
                .centerCrop()
                .into(imageDetail);
        titleDetail.setText(article.getTitle());
        fechaDetail.setText(article.getPublishedAt());
        descriptionDetail.setText(article.getDescription());
        contentDetail.setText(article.getContent());
        nameDetail.setText("By: " + article.getSourceObject().getName());


    }
}