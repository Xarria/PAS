package com.library;

import java.util.List;
import java.util.UUID;

public interface UserRepoInterface {
    public void add(Object o);
    public User findUserById(UUID id);
    public User findUserByLogin(String login);
    public void modifyUser(String login, User user);
    public List<User> getUsers();
    public void activateOrDeactivateUser(User user, boolean active);
    public String toString(User user, RentRepoInterface repo);
    public String getAllRentsForUser(User user, RentRepoInterface rentRepo);
}
