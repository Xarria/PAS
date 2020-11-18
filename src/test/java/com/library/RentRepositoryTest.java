package com.library;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentRepositoryTest {

    private RentRepository currentRentRepository;
    private User user;
    private Elem element1, element2, element3;
    private Rent rent1, rent2, rent3;

    @BeforeEach
    void setUp() {
        currentRentRepository = new RentRepository();
        user = new Renter("Zofia", "Wlodarczyk", "ZOfiaW");
        element1 = new Book("Przygody", "dramat", "Andersen", 87);
        element2 = new Book("Godfather", "thriller", "Mario Puzo", 480);
        element3 = new Book("Test", "sensacja", "Anonim", 50);
        rent1 = new Rent(element1, user);
        rent2 = new Rent(element2, user);
        rent3 = new Rent(element3, user);

    }

    @Test
    void add() {
        currentRentRepository.add(rent1);
        currentRentRepository.add(rent2);
        currentRentRepository.add(rent3);
        Assert.assertEquals(3,currentRentRepository.getRentRepository().size());
    }

    @Test
    void remove() {
        currentRentRepository.add(rent1);
        currentRentRepository.add(rent2);
        currentRentRepository.add(rent3);
        currentRentRepository.remove(rent1);
        Assert.assertEquals(2,currentRentRepository.getRentRepository().size());
    }

    @Test
    void getAllRenterRents() {
        currentRentRepository.add(rent1);
        currentRentRepository.add(rent2);
        Assert.assertEquals(2,currentRentRepository.getAllUserRents(user).size());
    }
}