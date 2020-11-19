package com.library.Logic;

import com.library.Data.Elem;
import com.library.Data.Rent;
import com.library.Data.RentRepoInterface;
import com.library.Data.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentManager {
    private RentRepoInterface currentRents;

    public RentManager(RentRepoInterface currentRents, RentRepoInterface archiveRents) {
        this.currentRents = currentRents;
    }

//    wyszukiwanie obiektów według wartości klucza
    public Rent findRent(UUID id){
        return currentRents.findRent(id);
    }

//utworzenie alokacji
//utworzenie alokacji jest obwarowane co najmniej aktywnością Klienta oraz dostępnością (brakiem nie zakończonych alokacji) Zasobu
//czas rozpoczęcia tworzonej alokacji może być ustawiany jako przyszły
    public void createRent(User user, Elem element, LocalDate startTime) {
        if (!isRented(element) && user.getActive()) {
            Rent rent = new Rent(element, user);
            rent.setStartDate(startTime);
            user.addRent(rent);
            currentRents.add(rent);
        } else {
            System.out.println("Element jest już wypożyczony lub użytkownik nie jest aktywny");
        }
    }

    public boolean isRented(Elem element) {
        for(Rent rent : currentRents.getRents()){
            if(rent.getElement()==element){
                return true;
            }
        }
        return false;
    }
// zakończenie alokacji
    public void endRent(Rent rent) {
        currentRents.endRent(rent);
    }
// usuwanie alokacji
    public void removeRent(Rent rent){
        currentRents.remove(rent);
    }

    public void displayArray(ArrayList<Rent> elements) {
        for (Rent rent : elements) {
            System.out.println(rent);
        }
    }
// lista alokacji z możliwością filtrowania co najmniej według wartości kluczy Klientów i Zasobów
    public List<Rent> getRents(){
        return currentRents.getRents();
    }

    public ArrayList<Rent> getAllUserRents(UUID id) {
        System.out.println("Obecne wypożyczenia: ");
        return currentRents.getAllUserRents(id);
    }

    public Rent getRentForElement(UUID id){
        return currentRents.getRentForElement(id);
    }
}
