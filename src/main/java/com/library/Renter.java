package com.library;

import java.util.ArrayList;
import java.util.UUID;

public class Renter extends User{

    public Renter(String name, String surname, String login) {
        super(name, surname, login);
    }

    public String toString(){
        return "\nWypożyczający" + super.toString();
    }
}
