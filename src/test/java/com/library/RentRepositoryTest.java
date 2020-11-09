package com.library;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentRepositoryTest {

    private RentRepository currentRentRepository;
    private Renter renter;
    private Elem element1, element2, element3;
    private Rent rent1, rent2, rent3;

    @BeforeEach
    void setUp() {
        currentRentRepository = new RentRepository();
        renter = new Renter("Zofia", "Wlodarczyk");
        element1 = new Book("Przygody", "dramat", "Andersen", 87);
        element2 = new Book("Godfather", "thriller", "Mario Puzo", 480);
        element3 = new Book("Test", "sensacja", "Anonim", 50);
        rent1 = new Rent(element1, renter);
        rent2 = new Rent(element2, renter);
        rent3 = new Rent(element3, renter);

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
        currentRentRepository.remove(rent1);
        Assert.assertEquals(2,currentRentRepository.getRentRepository().size());
    }

    @Test
    void getAllRenterRents() {
        Assert.assertEquals(2,currentRentRepository.getAllRenterRents(renter).size());
    }
}