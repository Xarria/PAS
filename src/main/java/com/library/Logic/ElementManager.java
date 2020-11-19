package com.library.Logic;

import com.library.Data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ElementManager {
    private ElemRepoInterface elemRepo;

    public ElementManager(ElemRepoInterface elemRepo) {
        this.elemRepo = elemRepo;
    }

    public boolean setElementPlace(Elem element, Place place){
        if(elemRepo.isElementInRepository(element) && elemRepo.isPlaceFree(place)){
            element.setPlace(place);
            return true;
        }
        return false;
    }
//wyszukiwanie obiektów według wartości klucza
    public Elem findElement(UUID id){
        return elemRepo.findElement(id);
    }
//zestaw operacji CRUD (tworzenie, odczyt (lista), modyfikacja, usuwanie) dla hierarchii Zasobów
    public void modifyElement(UUID id, Elem elem){
        elemRepo.modifyElement(id, elem);
    }

    public Book createBook(String name, String genre, String author, int pages){
        return new Book(name, genre, author, pages);
    }

    public Newspaper createNewspaper(String name, String genre){
        return new Newspaper(name, genre);
    }

    public List<Elem> getElements(){
        return elemRepo.getElements();
    }

    public void add(Elem elem){
        elemRepo.add(elem);
    }

    public void remove(Elem elem){
        elemRepo.remove(elem);
    }
// wyświetlenie szczegółów wraz z listą alokacji
    public String toString(Elem element, RentRepoInterface rentRepo){
        return elemRepo.toString(element, rentRepo);
    }

    public ArrayList<Elem> getAllFromGenre(String genre){
        return elemRepo.getAllElementsFromGenre(genre);
    }

    public ArrayList<Book> getBooksByAuthor(String author){
        return elemRepo.findBooksByAuthor(author);
    }

    public ArrayList<Elem> getAllByTitle(String title){
        return elemRepo.findByTitle(title);
    }

    public Place findElementPlace(Elem element){
        return elemRepo.findElementPlace(element);
    }

    public void displayArray(ArrayList<Elem> elements){
        for(Elem elem : elements){
            System.out.println(elem);
        }
    }
}
