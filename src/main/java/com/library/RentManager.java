package com.library;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentManager {
    private RentRepository currentRents;
    private RentRepository archiveRents;

    public RentManager(RentRepository currentRents, RentRepository archiveRents) {
        this.currentRents = currentRents;
        this.archiveRents = archiveRents;
    }

    public void createRent(Renter renter, Elem element){
        if(!isRented(element)){
            Rent rent = new Rent(element, renter);
            currentRents.add(rent);
        }
        else{
            System.out.println("Element jest już wypożyczony");
        }
    }

    public boolean isRented(Elem element){
        for(Rent rent : currentRents.getRentRepository()){
            if(rent.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public void endRent(Rent rent){
        rent.setEndDate(LocalDate.now());
        currentRents.remove(rent);
        archiveRents.add(rent);
    }

    public void getAllRenterRents(Renter renter){
        System.out.println("Obecne wypożyczenia: ");
        ArrayList<Rent> current = currentRents.getAllRenterRents(renter);
        displayArray(current);
        System.out.println("Archiwalne wypożyczenia: ");
        ArrayList<Rent> archive = archiveRents.getAllRenterRents(renter);
        displayArray(archive);
    }

    public void displayArray(ArrayList<Rent> elements){
        for(Rent rent: elements){
            System.out.println(rent);
        }
    }

}
