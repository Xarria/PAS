package com.library;

import java.util.ArrayList;

public class RenterRepository {
    ArrayList<Renter> renters;

    public RenterRepository() {
        this.renters = new ArrayList<>();
    }

    public void add(Renter renter){
        renters.add(renter);
    }

    public void remove(Renter renter){
        renters.remove(renter);
    }

}
