package com.library;

import java.util.ArrayList;
import java.util.List;

public class RenterRepository {
    private ArrayList<Renter> renters;

    public RenterRepository() {
        this.renters = new ArrayList<>();
    }

    public void add(Renter renter){
        renters.add(renter);
    }

    public void remove(Renter renter){
        renters.remove(renter);
    }

    public List<Renter> getRenters() {
        return renters;
    }

}
