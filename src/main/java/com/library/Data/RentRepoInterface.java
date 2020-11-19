package com.library.Data;

import com.library.Data.Rent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface RentRepoInterface {
    void add(Rent rent);
    void remove(Rent rent);
    String toString();
    Rent findRent(UUID id);
    ArrayList<Rent> getAllUserRents(UUID id);
    String getRent(Rent rent);
    List<Rent> getRents();
    Rent getRentForElement(UUID id);
    void endRent(Rent rent);
}
