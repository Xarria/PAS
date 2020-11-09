package com.library;

public class RenterManager {
    private RenterRepository currentRenters;
    private RenterRepository archiveRenters;

    public RenterManager(RenterRepository currentRenters, RenterRepository archiveRenters) {
        this.currentRenters = currentRenters;
        this.archiveRenters = archiveRenters;
    }

    public void addRenter(Renter renter){
        currentRenters.getRenters().add(renter);
    }

    public void removeRenter(Renter renter){
        currentRenters.getRenters().remove(renter);
        archiveRenters.getRenters().add(renter);
    }

    public void changeRenterType(RenterType type, Renter renter){
        renter.setType(type);
    }
}
