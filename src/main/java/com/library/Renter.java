package com.library;

import java.util.ArrayList;
import java.util.UUID;

public class Renter {
    private ArrayList<Rent> rents = new ArrayList<>();
    private RenterType type;
    private String name;
    private String surname;
    private UUID id;

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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UUID getId() {
        return id;
    }

    public RenterType getType() {
        return type;
    }

    public double getPenalty(){
        int days = 0;
        for (Rent rent : rents) {
            days += rent.getDaysOver();
        }
        return days * type.getDailyPenalty();
    }
}
