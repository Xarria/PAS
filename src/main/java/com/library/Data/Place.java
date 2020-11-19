package com.library.Data;

public class Place {
    private String rack;
    private int position;

    public Place(String rack, int position) {
        this.rack = rack;
        this.position = position;
    }

    public String getRack() {
        return rack;
    }

    public int getPosition() {
        return position;
    }

}
