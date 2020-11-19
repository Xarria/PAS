package com.library.Data;

public class ResourceAdmin extends User {


    public ResourceAdmin(String name, String surname, String login) {
        super(name, surname, login);
    }

    @Override
    public String toString(){
        return "\nZarządca zasobów" + super.toString();
    }
}
