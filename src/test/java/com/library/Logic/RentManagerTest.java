package com.library.Logic;

import com.library.Data.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class RentManagerTest {

    private RentManager rentManager;
    private User user;
    private Elem element;
    private Rent rent;

    @BeforeEach
    void setUp() {
        RentRepository currentRentRepository = new RentRepository();
        RentRepository archiveRentRepository = new RentRepository();
        rentManager = new RentManager(currentRentRepository, archiveRentRepository);
        user = new Renter("Zofia", "Wlodarczyk", "ZofiaW");
        UserManager userManager = new UserManager(new UserRepository());
        userManager.activateOrDeactivateUser(user, true);
        element = new Book("Przygody", "dramat", "Andersen", 87);
        rent = new Rent(element, user);
    }

    @Test
    void isRented() {
        rentManager.createRent(user, element, LocalDate.now());
        Assert.assertTrue(rentManager.isRented(element));
    }

    @Test
    void endRent() {
        rentManager.endRent(rent);
        Assert.assertFalse(rentManager.isRented(element));
    }
}