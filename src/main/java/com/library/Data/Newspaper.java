package com.library.Data;

public class Newspaper extends Elem {

    public Newspaper(String name, String genre) {
        super(name, genre);
    }

    @Override
    public String toString(){
        return "\nGazeta" + super.toString();
    }
}
