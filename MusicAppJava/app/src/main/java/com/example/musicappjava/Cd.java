package com.example.musicappjava;

import java.util.List;

public class Cd {
    private String nameCD;
    private String bandCD;
    private String imageCD;
    private String infoCD;
    private List<Song> songs;

    public Cd(String nameCD, String bandCD, String imageCD, String infoCD, List<Song> songs) {
        this.nameCD = nameCD;
        this.bandCD = bandCD;
        this.imageCD = imageCD;
        this.infoCD = infoCD;
        this.songs = songs;
    }

    public String getNameCD() {
        return nameCD;
    }

    public String getBandCD() {
        return bandCD;
    }

    public String getImageCD() {
        return imageCD;
    }

    public String getInfoCD() {
        return infoCD;
    }

    public List<Song> getSongs() {
        return songs;
    }

}
