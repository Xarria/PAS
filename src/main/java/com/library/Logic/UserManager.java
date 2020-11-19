package com.library.Logic;

import com.library.Data.RentRepoInterface;
import com.library.Data.RenterType;
import com.library.Data.User;
import com.library.Data.UserRepoInterface;

import java.util.List;
import java.util.UUID;

public class UserManager {
    private UserRepoInterface currentUsers;

    public UserManager(UserRepoInterface currentUsers) {
        this.currentUsers = currentUsers;
    }
//wyszukiwanie obiektów według wartości klucza, w przypadku hierarchii Użytkowników także według wartości identyfikatora tekstowego
    public User findUserById(UUID id){
        return currentUsers.findUserById(id);
    }

//zestaw operacji CRU (tworzenie, odczyt (lista), modyfikacja) dla hierarchii Użytkowników
    public void modifyUser(String login, User user){
        currentUsers.modifyUser(login, user);
    }

    public List<User> getUsers(){
        return currentUsers.getUsers();
    }

    public User createUser(String name, String surname, String login){
        return new User(name, surname, login);
    }

//wyszukiwanie obiektów według wartości klucza, w przypadku hierarchii Użytkowników także według wartości identyfikatora tekstowego
    public User findUserByLogin(String login){
        return currentUsers.findUserByLogin(login);
    }

    public void add(User user){
        currentUsers.add(user);
    }

    public void changeRenterType(RenterType type, User user){
        user.setType(type);
    }
//aktywowanie i deaktywowanie Użytkownika
    public void activateOrDeactivateUser(User user, boolean active) {
        currentUsers.activateOrDeactivateUser(user, active);
    }
//wyświetlenie szczegółów wraz z listą alokacji
    public String toString(User user, RentRepoInterface repo) {
        return currentUsers.toString(user, repo);
    }
}
