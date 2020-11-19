package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository implements UserRepoInterface {
    private ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

//listy Użytkowników oraz Zasobów powinny udostępniać możliwość filtrowania co najmniej według wartości klucza
    public User findUserById(UUID id){
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findUserByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void modifyUser(String login, User user){
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getLogin().equals(login)){
                users.set(i, user);
            }
        }
    }

    public void add(Object userObject){
        User user = (User) userObject;
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin())) {
                System.out.println("Istnieje już użytkownik o danym loginie");
                return;
            }
            else if (u.getId() == user.getId()){
                System.out.println("Istnieje już użytkownik o danym id");
                return;
            }
            users.add(user);
        }

        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void activateOrDeactivateUser(User user, boolean active) {
        user.setActive(active);
    }

    public String toString(User user, RentRepoInterface rentRepo) {
        StringBuilder str = new StringBuilder();
        str.append(user.toString());
        str.append(user.getRents());
        str.append(getAllRentsForUser(user, rentRepo));
        return str.toString();
    }

    public String getAllRentsForUser(User user, RentRepoInterface rentRepo){
        StringBuilder str = new StringBuilder();
        ArrayList<Rent> rents = rentRepo.getAllUserRents(user.getId());
        for (Rent rent : rents) {
            str.append(rent);
        }
        return str.toString();
    }
}
