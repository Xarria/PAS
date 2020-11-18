package com.library;

import java.util.ArrayList;
import java.util.UUID;

public class ElementManager {
    private ElementRepository elemRepo;

    public ElementManager(ElementRepository elemRepo) {
        this.elemRepo = elemRepo;
    }

    public boolean setElementPlace(Elem element, Place place){
        if(elemRepo.isElementInRepository(element) && elemRepo.isPlaceFree(place)){
            element.setPlace(place);
            return true;
        }
        return false;
    }

    public Elem findElement(UUID id){
        return elemRepo.findElement(id);
    }

    public void modifyElement(UUID id, Elem elem){
        elemRepo.modifyElement(id, elem);
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
