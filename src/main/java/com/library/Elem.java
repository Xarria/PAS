package com.library;

import java.util.UUID;

public class Elem {

    private String name;
    private String genre;
    private UUID id;
    private Place place;

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

    public Place getPlace() {
        return place;
    }

    @Override
    public String toString(){
        return ", tytuł: " + name + "\ngatunek: " + genre + "\nRegał: " + place.getRack() + ", pozycja: " + place.getPosition();
    }

    public void setPlace(Place newPlace) {
        this.place = newPlace;
    }

    public UUID getId() {
        return id;
    }

}
