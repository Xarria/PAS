package com.library;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

public class Rent {
    private Elem element;
    private User user;
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rent(Elem element, User user) {
        this.element = element;
        this.user = user;
        this.id = UUID.randomUUID();
        startDate = LocalDate.now();
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void createRent(Elem element, User user){
        Rent rent = new Rent(element, user);
        user.addRent(rent);
    }

    @Override
    public String toString(){
        return "\nID: " + id + ", login: " + user.getLogin() + "\nImię: " + user.getName() + "\nNazwisko: " + user.getSurname() + "\nTytuł: " + element.getName() +
                "\nData rozpoczęcia: " + startDate + "\nData zakończenia: " + endDate;
    }

    public Elem getElement() {
        return element;
    }

    public User getUser() {
        return user;
    }

    public int getDaysOver(){
        if(endDate == null){
            return 0;
        }
        int duration = (int) Duration.between(startDate, endDate).toDays();
        int daysOver = duration - user.getMaxRentDays();
        return Math.max(daysOver, 0);
    }

    public UUID getId() {
        return id;
    }
}
