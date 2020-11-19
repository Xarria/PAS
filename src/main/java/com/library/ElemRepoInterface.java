package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface ElemRepoInterface {

    public void add(Object element);
    public void remove(Elem elem);
    public Elem findElement(UUID id);
    public void modifyElement(UUID id, Elem elem);
    public boolean isElementInRepository(Elem elem);
    public boolean isPlaceFree(Place place);
    public ArrayList<Elem> getAllElementsFromGenre(String g);
    public ArrayList<Book> findBooksByAuthor(String a);
    public ArrayList<Elem> findByTitle(String title);
    public Place findElementPlace(Elem element);
    public String toString(Elem elem, RentRepoInterface rentRepo);
    public String getRentForElement(Elem elem, RentRepoInterface rentRepo);
    public List<Elem> getElements();
}
