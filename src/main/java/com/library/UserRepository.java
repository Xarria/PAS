package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

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
            if (user.getLogin() == login) {
                return user;
            }
        }
        return null;
    }

    public void modifyUser(String login, User user){
        for (int i = 0; i < users.size(); i++){
            if(users.get(i).getLogin() == login){
                users.set(i, user);
            }
        }
    }

    public void add(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void activateOrDeactivateUser(User user, boolean active) {
        user.setActive(active);
    }

    public String toString(User user) {
        StringBuilder str = new StringBuilder();
        str.append(user.toString());
        str.append(user.getRents());
        return str.toString();
    }
}
