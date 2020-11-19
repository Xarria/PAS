package com.library.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentRepository implements RentRepoInterface {
    private final ArrayList<Rent> repository;

    public ArrayList<Rent> getRentRepository() {
        return repository;
    }

    public RentRepository() {
        this.repository = new ArrayList<>();
    }

    public void add(Rent rent) {
        for (Rent r : repository) {
            if (r.getId() == rent.getId()) {
                System.out.println("Istnieje już wypożyczenie o danym id");
                return;
            }
        }
        repository.add(rent);
    }
// zakończenie alokacji polega na ustawieniu atrybutu czasu zakończenia alokacji
    public void endRent(Rent rent){
        for (Rent r : repository) {
            if (r.getId() == rent.getId()) {
                rent.setEndDate(LocalDate.now());
            } else {
                System.out.println("Brak podanego wypożyczenia");
            }
        }
    }
//usuwanie alokacji dotyczy tylko alokacji nie zakończonych
    public void remove(Rent rent){
        if(rent.getEndDate() == null){
            repository.remove(rent);
        }
        else {
            System.out.println("Nie można usunąć zakończonego wypożyczenia");
        }
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

    public ArrayList<Rent> getAllUserRents(UUID id){
        ArrayList<Rent> userRents = new ArrayList<>();
        for (Rent rent : repository) {
            if (rent.getUser().getId() == id) {
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

    public Rent getRentForElement(UUID id){
        for(Rent rent : repository){
            if(rent.getElement().getId() == id){
                return rent;
            }
        }
        return null;
    }

    public List<Rent> getRents(){
        return repository;
    }
}
