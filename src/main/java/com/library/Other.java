package com.library;

public class Other implements RenterType {
    @Override
    public int getMaxRentDuration() {
        return 30;
    }

    @Override
    public double getDailyPenalty() {
        return 1.20;
    }

    @Override
    public String toString(){
        return "inny";
    }
}
