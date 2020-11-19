package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface RentRepoInterface {
    public void add(Object rentObject);
    public void remove(Rent rent);
    public String toString();
    public Rent findRent(UUID id);
    public ArrayList<Rent> getAllUserRents(UUID id);
    public String getRent(Rent rent);
    public List<Rent> getRents();
    public Rent getRentForElement(UUID id);
    public void endRent(Rent rent);
}
