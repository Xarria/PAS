package com.library;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

public class Rent {
    Elem element;
    Renter renter;
    UUID id;
    LocalDate startDate;
    LocalDate endDate;

    public Rent(Elem element, Renter renter) {
        this.element = element;
        this.renter = renter;
        this.id = UUID.randomUUID();
        startDate = LocalDate.now();
    }

    public void createRent(Elem element, Renter renter){
        Rent rent = new Rent(element, renter);
        renter.addRent(rent);
    }

    @Override
    public String toString(){
        return "\nID: " + id + "\nImię: " + renter.name + "\nNazwisko: " + renter.surname + "\nTytuł: " + element.name +
                "\nData rozpoczęcia: " + startDate + "\nData zakończenia: " + endDate;
    }

    public Elem getElement() {
        return element;
    }

    public Renter getRenter() {
        return renter;
    }

    public int getDaysOver(){
        if(endDate == null){
            return 0;
        }
        int duration = (int) Duration.between(startDate, endDate).toDays();
        int daysOver = duration - renter.getMaxRentDays();
        return Math.max(daysOver, 0);
    }
}
