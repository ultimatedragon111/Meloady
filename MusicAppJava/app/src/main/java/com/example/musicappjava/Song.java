package com.example.musicappjava;

public class Song {
    private String nameSong;
    private String imageSong;
    private String bandSong;

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getImageSong() {
        return imageSong;
    }

    public void setImageSong(String imageSong) {
        this.imageSong = imageSong;
    }

    public String getBandSong() {
        return bandSong;
    }

    public void setBandSong(String bandSong) {
        this.bandSong = bandSong;
    }

    public short getYearSong() {
        return yearSong;
    }

    public void setYearSong(short yearSong) {
        this.yearSong = yearSong;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    private short yearSong;
    private String lyrics;

    public Song(String nameSong, String imageSong, String bandSong, short yearSong, String lyrics) {
        this.nameSong = nameSong;
        this.imageSong = imageSong;
        this.bandSong = bandSong;
        this.yearSong = yearSong;
        this.lyrics = lyrics;
    }
}

