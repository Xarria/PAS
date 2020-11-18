package com.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class RentManager {
    private RentRepository currentRents;
    private RentRepository archiveRents;

    public RentManager(RentRepository currentRents, RentRepository archiveRents) {
        this.currentRents = currentRents;
        this.archiveRents = archiveRents;
    }

    public Rent findRent(UUID id){
        return currentRents.findRent(id);
    }

    public void createRent(User user, Elem element) {
        if (!isRented(element)) {
            Rent rent = new Rent(element, user);
            currentRents.add(rent);
        } else {
            System.out.println("Element jest już wypożyczony");
        }
    }

    public boolean isRented(Elem element) {
        for (Rent rent : currentRents.getRentRepository()) {
            if (rent.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void endRent(Rent rent) {
        rent.setEndDate(LocalDate.now());
        currentRents.remove(rent);
        archiveRents.add(rent);
    }

    public void getAllUserRents(User user) {
        System.out.println("Obecne wypożyczenia: ");
        ArrayList<Rent> current = currentRents.getAllUserRents(user);
        displayArray(current);
        System.out.println("Archiwalne wypożyczenia: ");
        ArrayList<Rent> archive = archiveRents.getAllUserRents(user);
        displayArray(archive);
    }

    public void displayArray(ArrayList<Rent> elements) {
        for (Rent rent : elements) {
            System.out.println(rent);
        }
    }

    public Rent getRentForElem(Elem elem) {
        for (Rent rent : currentRents.getRentRepository()) {
            if (rent.getElement() == elem)
                return rent;
        }
        return null;
    }
}
