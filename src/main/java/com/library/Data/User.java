package com.library.Data;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    private RenterType type;
    private ArrayList<Rent> rents = new ArrayList<>();
    private String name;
    private String surname;
    private String login;
    private UUID id;
    private boolean active;

    public User(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
        this.login = login;
    }

    @Override
    public String toString(){
        return "\n o loginie: " + login + "imieniu: " + name + " i nazwisku: " + surname + ", id: " + id + ", typ: " + type.toString() +
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

    public String getLogin() {
        return login;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive(){
        return active;
    }
}
