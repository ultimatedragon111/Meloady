package com.example.marvelexamen2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.gson.Gson;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayerBridge;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class DetaiActivity extends AppCompatActivity {

    Article article;
    String name;
    private ImageView imageDetail;
    private TextView titleDetail,fechaDetail,descriptionDetail,contentDetail,nameDetail;
    private ViewPager viewPager;
    private VideoView videoView;
    private Button buttonUrl,buttonWeb,buttonContact;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai);

        Gson gson = new Gson();
        Article article = gson.fromJson(getIntent().getStringExtra("myjson"), Article.class);
        name = getIntent().getStringExtra("name");

        viewPager =  findViewById(R.id.viwerPager);
        imageDetail = findViewById(R.id.imageDetail);
        titleDetail = findViewById(R.id.titleDetail);
        fechaDetail = findViewById(R.id.fechaDetail);
        descriptionDetail = findViewById(R.id.descriptionDetail);
        contentDetail = findViewById(R.id.contentDetail);
        nameDetail = findViewById(R.id.nameDetail);
        buttonUrl = findViewById(R.id.urlButton);
        buttonWeb = findViewById(R.id.webButton);
        buttonContact = findViewById(R.id.contactButton);
        recyclerView = findViewById(R.id.recyclerComments);

        Picasso.get().load(article.getUrlToImage())
                .fit()
                .centerCrop()
                .into(imageDetail);
        titleDetail.setText(article.getTitle());
        fechaDetail.setText(article.getPublishedAt());
        descriptionDetail.setText(article.getDescription());
        contentDetail.setText(article.getContent());
        nameDetail.setText(article.getSource().getName());
        ImageAdapter imageAdapter = new ImageAdapter(this, article.getMedia());
        viewPager.setAdapter(imageAdapter);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = article.getUrlvideo().substring(30);
                youTubePlayer.cueVideo(videoId, 0);
            }
        });

        buttonUrl.setOnClickListener(v -> {
            String url = article.getUrl();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        });
        buttonWeb.setOnClickListener(v -> {
            String url = article.getAuthorlink();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        });
        buttonContact.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            String[] TO = {article.getContact()};

            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");

            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject of the mail");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "This is the text to send with the mail");
            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(this, "There is no email client installed.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MyAdapterComments adapter = new MyAdapterComments(getApplicationContext(),article.getComments());
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);



    }
}