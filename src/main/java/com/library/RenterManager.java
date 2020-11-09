package com.library;

public class RenterManager {
    RenterRepository currentRenters;
    RenterRepository archiveRenters;

    public RenterManager(RenterRepository currentRenters, RenterRepository archiveRenters) {
        this.currentRenters = currentRenters;
        this.archiveRenters = archiveRenters;
    }

    public void addRenter(Renter renter){
        currentRenters.renters.add(renter);
    }

    public void removeRenter(Renter renter){
        currentRenters.renters.remove(renter);
        archiveRenters.renters.add(renter);
    }

    public void changeRenterType(RenterType type, Renter renter){
        renter.setType(type);
    }
}
