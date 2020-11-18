package com.library;

import java.util.UUID;

public class UserManager {
    private UserRepository currentUsers;

    public UserManager(UserRepository currentUsers) {
        this.currentUsers = currentUsers;
    }

    public User findUserById(UUID id){
        return currentUsers.findUserById(id);
    }

    public void modifyUser(String login, User user){
        currentUsers.modifyUser(login, user);
    }

    public User findUserByLogin(String login){
        return currentUsers.findUserByLogin(login);
    }

    public void addRenter(User user){
        currentUsers.getUsers().add(user);
    }

    public void removeRenter(User user){
        currentUsers.getUsers().remove(user);
    }

    public void changeRenterType(RenterType type, User user){
        user.setType(type);
    }
}
