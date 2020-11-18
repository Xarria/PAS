package com.library;

import java.util.ArrayList;
import java.util.UUID;

public class RentRepository {
    private ArrayList<Rent> repository;

    public ArrayList<Rent> getRentRepository() {
        return repository;
    }

    public RentRepository() {
        this.repository = new ArrayList<>();
    }

    public void add(Rent rent){
        repository.add(rent);
    }

    public void remove(Rent rent){
        repository.remove(rent);
    }

    @Override
    public String toString(){
        StringBuilder txt = new StringBuilder();
        for (Rent rent : repository) {
            txt.append(rent.toString());
        }
        return txt.toString();
    }

    public Rent findRent(UUID id){
        for (Rent rent : repository) {
            if (rent.getId() == id) {
                return rent;
            }
        }
        return null;
    }

    public ArrayList<Rent> getAllUserRents(User person){
        ArrayList<Rent> userRents = new ArrayList<>();
        for (Rent rent : repository) {
            if (rent.getUser() == person) {
                userRents.add(rent);
            }
        }
        return userRents;
    }

    public String getRent(Rent rent){
        for (Rent value : repository) {
            if (value.equals(rent)) {
                return value.toString();
            }
        }
        return "Brak podanego wypożyczenia w repozytorium";
    }
}
