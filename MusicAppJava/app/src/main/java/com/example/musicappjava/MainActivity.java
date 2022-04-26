package com.example.musicappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    List CDs;
    List<Cd> cds = new ArrayList<>();
    List<Song> songs = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = findViewById(R.id.recyclerHori11);
        recyclerView2 = findViewById(R.id.recy2);
        MyAdapter myAdapter = new MyAdapter((ArrayList<Cd>) cds, this);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer);

        MyAdapter2 myAdapter2 = new MyAdapter2((ArrayList<Song>) songs, this);
        recyclerView2.setAdapter(myAdapter2);
        recyclerView2.setLayoutManager(new GridLayoutManager(this, 1,        RecyclerView.VERTICAL, false));


    }
    private void initData(){
        String lyrics = "Load up on guns, bring your friends\n" +
                "It's fun to lose and to pretend\n" +
                "She's over-bored and self-assured\n" +
                "Oh, no, I know a dirty word\n" +
                "\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello\n" +
                "\n" +
                "With the lights out\n" +
                "It's less dangerous\n" +
                "Here we are now, entertain us\n" +
                "I feel stupid and contagious\n" +
                "Here we are now, entertain us\n" +
                "A mulatto, an albino\n" +
                "A mosquito, my libido\n" +
                "Yeah, hey, yay\n" +
                "\n" +
                "I'm worse at what I do best\n" +
                "And for this gift I feel blessed\n" +
                "Our little group has always been\n" +
                "And always will until the end\n" +
                "\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello\n" +
                "\n" +
                "With the lights out\n" +
                "It's less dangerous\n" +
                "Here we are now, entertain us\n" +
                "I feel stupid and contagious\n" +
                "Here we are now, entertain us\n" +
                "A mulatto, an albino\n" +
                "A mosquito, my libido\n" +
                "Yeah, hey, yay\n" +
                "\n" +
                "And I forget just why I taste\n" +
                "Oh, yeah, I guess it makes me smile\n" +
                "I found it hard, it's hard to find\n" +
                "Well, whatever, nevermind\n" +
                "\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello, how low\n" +
                "Hello, hello, hello\n" +
                "\n" +
                "With the lights out\n" +
                "It's less dangerous\n" +
                "Here we are now, entertain us\n" +
                "I feel stupid and contagious\n" +
                "Here we are now, entertain us\n" +
                "A mulatto, an albino\n" +
                "A mosquito, my libido\n" +
                "\n" +
                "A denial, a denial, a denial\n" +
                "A denial, a denial, a denial\n" +
                "A denial, a denial, a denial";
        //1
        Song song11 = new Song("Title Song1 CD 1", "Name Band 1","https://joanseculi.com/images/cds/cd01.jpg", (short)2010, lyrics);
        Song song12 = new Song("Title Song2 CD 1", "Name Band 1","https://joanseculi.com/images/cds/cd01.jpg", (short)2010, lyrics);
        Song song13 = new Song("Title Song3 CD 1", "Name Band 1","https://joanseculi.com/images/cds/cd01.jpg", (short)2010, lyrics);
        Song song14 = new Song("Title Song4 CD 1", "Name Band 1","https://joanseculi.com/images/cds/cd01.jpg", (short)2010, lyrics);
        Song song15 = new Song("Title Song5 CD 1", "Name Band 1","https://joanseculi.com/images/cds/cd01.jpg", (short)2010, lyrics);
        Song song16 = new Song("Title Song6 CD 1", "Name Band 1","https://joanseculi.com/images/cds/cd01.jpg", (short)2010, lyrics);
        List<Song> songs1 = new ArrayList<>();
        songs1.add(song11);
        songs1.add(song12);
        songs1.add(song13);
        songs1.add(song14);
        songs1.add(song15);
        songs1.add(song16);
        Cd cd1 = new Cd("Name CD 1", "https://joanseculi.com/images/cds/cd01.jpg", "Name Band 1",
                "This is a description of the band 1, this constains information about the genre, the members of the band and also it contains the history of the band",
                songs1);


        cds.add(cd1);

        //2
        Song song21 = new Song("Title Song1 CD 2", "Name Band 2", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song22 = new Song("Title Song2 CD 2", "Name Band 2", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song23 = new Song("Title Song3 CD 2", "Name Band 2", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song24 = new Song("Title Song4 CD 2", "Name Band 2", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song25 = new Song("Title Song5 CD 2", "Name Band 2", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song26 = new Song("Title Song6 CD 2", "Name Band 2", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);

        List<Song> songs2 = new ArrayList<>();
        songs2.add(song21);
        songs2.add(song22);
        songs2.add(song23);
        songs2.add(song24);
        songs2.add(song25);
        songs2.add(song26);


        Cd cd2 = new Cd("Name CD 2", "https://joanseculi.com/images/cds/cd02.jpg", "Name Band 2",
                "This is a description of the band 2, this constains information about the genre, the members of the band and also it contains the history of the band",
                songs2);

        cds.add(cd2);
        //3
        Song song31 = new Song("Title Song1 CD 3", "Name Band 3", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song32 = new Song("Title Song2 CD 3", "Name Band 3", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song33 = new Song("Title Song3 CD 3", "Name Band 3", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song34 = new Song("Title Song4 CD 3", "Name Band 3", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song35 = new Song("Title Song5 CD 3", "Name Band 3", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song36 = new Song("Title Song6 CD 3", "Name Band 3", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);
        Song song37 = new Song("Title Song7 CD 3", "Name Band 3", "https://joanseculi.com/images/cds/cd02.jpg",(short)2010,
                lyrics);

        List<Song> songs3 = new ArrayList<>();
        songs3.add(song31);
        songs3.add(song32);
        songs3.add(song33);
        songs3.add(song34);
        songs3.add(song35);
        songs3.add(song36);
        songs3.add(song37);
        Cd cd3 = new Cd("Name CD 3", "https://joanseculi.com/images/cds/cd03.jpg", "Name Band 3",
                "This is a description of the band 3, this constains information about the genre, the members of the band and also it contains the history of the band",
                songs3);

        cds.add(cd3);
        //4
        Song song41 = new Song("Title Song1 CD 4", "Name Band 4", "https://joanseculi.com/images/cds/cd04.jpg",(short)2010,
                lyrics);
        Song song42 = new Song("Title Song2 CD 4", "Name Band 4", "https://joanseculi.com/images/cds/cd04.jpg",(short)2010,
                lyrics);
        Song song43 = new Song("Title Song3 CD 4", "Name Band 4", "https://joanseculi.com/images/cds/cd04.jpg",(short)2010,
                lyrics);
        Song song44 = new Song("Title Song4 CD 4", "Name Band 4", "https://joanseculi.com/images/cds/cd04.jpg",(short)2010,
                lyrics);
        Song song45 = new Song("Title Song5 CD 4", "Name Band 4", "https://joanseculi.com/images/cds/cd04.jpg",(short)2010,
                lyrics);
        List<Song> songs4 = new ArrayList<>();
        songs4.add(song41);
        songs4.add(song42);
        songs4.add(song43);
        songs4.add(song44);
        songs4.add(song45);
        Cd cd4 = new Cd("Name CD 4", "https://joanseculi.com/images/cds/cd04.jpg", "Name Band 4",
                "This is a description of the band 4, this constains information about the genre, the members of the band and also it contains the history of the band",
                songs4);

        cds.add(cd4);

        songs.add(song11);
        songs.add(song21);


        songs.add(song12);
        songs.add(song22);

        songs.add(song13);
        songs.add(song23);

        songs.add(song14);
        songs.add(song24);

        songs.add(song15);
        songs.add(song25);

        songs.add(song16);
        songs.add(song26);


    }
}