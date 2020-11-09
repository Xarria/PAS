package com.library;

import java.util.ArrayList;

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

    public ArrayList<Rent> getAllRenterRents(Renter person){
        ArrayList<Rent> renterRents = new ArrayList<>();
        for (Rent rent : repository) {
            if (rent.getRenter() == person) {
                renterRents.add(rent);
            }
        }
        return renterRents;
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
