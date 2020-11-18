package com.library;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentManagerTest {

    private RentRepository currentRentRepository;
    private RentRepository archiveRentRepository;
    private RentManager rentManager;
    private User user;
    private Elem element;
    private Rent rent;

    @BeforeEach
    void setUp() {
        currentRentRepository = new RentRepository();
        archiveRentRepository = new RentRepository();
        rentManager = new RentManager(currentRentRepository, archiveRentRepository);
        user = new Renter("Zofia", "Wlodarczyk", "ZofiaW");
        element = new Book("Przygody", "dramat", "Andersen", 87);
        rent = new Rent(element, user);
    }

    @Test
    void isRented() {
        rentManager.createRent(user, element);
        Assert.assertTrue(rentManager.isRented(element));
    }

    @Test
    void endRent() {
        rentManager.endRent(rent);
        Assert.assertFalse(rentManager.isRented(element));
    }
}