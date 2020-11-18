package com.library;

public class Admin extends Renter {

    public Admin(String name, String surname, String login) {
        super(name, surname, login);
    }

    @Override
    public String toString(){
        return "\nAdministrator" + super.toString();
    }
}
