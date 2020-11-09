package com.library;

import java.util.UUID;

public class Elem {

    String name;
    String genre;
    UUID id;
    Place place;

    public Elem(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }


    public String getGenre() {
        return genre;
    }

    @Override
    public String toString(){
        return ", tytuł: " + name + "\ngatunek: " + genre + "\nRegał: " + place.rack + ", pozycja: " + place.position;
    }

    public void setPlace(Place newPlace) {
        this.place = newPlace;
    }

    public UUID getId() {
        return id;
    }

}
