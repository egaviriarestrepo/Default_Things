package com.example.egaviria.defaultactivities.class_items;

/**
 * Created by egaviria on 31/10/17.
 */

public class Film {

    public String name;
    public int poster;

    public Film() {
    }

    public Film(String name, int poster) {
        this.name = name;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
