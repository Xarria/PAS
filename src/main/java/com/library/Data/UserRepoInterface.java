package com.library.Data;

import java.util.List;
import java.util.UUID;

public interface UserRepoInterface {
    void add(Object o);
    User findUserById(UUID id);
    User findUserByLogin(String login);
    void modifyUser(String login, User user);
    List<User> getUsers();
    void activateOrDeactivateUser(User user, boolean active);
    String toString(User user, RentRepoInterface repo);
    String getAllRentsForUser(User user, RentRepoInterface rentRepo);
}
