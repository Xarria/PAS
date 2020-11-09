package com.library;

import java.util.ArrayList;
import java.util.UUID;

public class Renter {
    ArrayList<Rent> rents = new ArrayList<>();
    RenterType type;
    String name;
    String surname;
    UUID id;

    public Renter(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString(){
        return "\nWypożyczający o imieniu: " + name + " i nazwisku: " + surname + ", id: " + id + ", typ: " + type.toString() +
                "\nMaksymalny czas wypożyczenia: " + type.getMaxRentDuration() + ", kara dzienna: " + type.getDailyPenalty();
    }

    public String getRents(){
        StringBuilder txt = new StringBuilder();
        for (Rent rent : rents) {
            txt.append(rent.toString());
        }
        return txt.toString();
    }

    public void setType(RenterType type) {
        this.type = type;
    }

    public int getMaxRentDays(){
        return type.getMaxRentDuration();
    }

    public void addRent(Rent rent){
        rents.add(rent);
    }

    public double getPenalty(){
        int days = 0;
        for (Rent rent : rents) {
            days += rent.getDaysOver();
        }
        return days * type.getDailyPenalty();
    }
}
