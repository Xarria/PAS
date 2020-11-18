package com.library;

import java.util.ArrayList;
import java.util.UUID;

public class ElementRepository {
    private ArrayList<Elem> elements;

    public ElementRepository() {
        this.elements = new ArrayList<>();
    }

    public void add(Elem elem){
        elements.add(elem);
    }

    public void remove(Elem elem){
        elements.set(elements.indexOf(elem), null);
    }

    public Elem findElement(UUID id) {
        for (Elem elem : elements) {
            if (elem.getId() == id) {
                return elem;
            }
        }
        return null;
    }

    public void modifyElement(UUID id, Elem elem){
        for(int i = 0; i < elements.size(); i++){
            if (elements.get(i).getId() == id){
                elements.set(i, elem);
            }
        }
    }

    public boolean isElementInRepository(Elem elem){
        for(Elem e: elements){
            if(e.equals(elem)){
                return true;
            }
        }
        return false;
    }

    public boolean isPlaceFree(Place place){
        for(Elem elem: elements){
            if(elem.getPlace() == place){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Elem> getAllElementsFromGenre(String g){
        ArrayList<Elem> fromGenre = new ArrayList<>();
        for(Elem elem: elements){
            if(elem.getGenre().equals(g)){
                fromGenre.add(elem);
            }
        }
        return fromGenre;
    }

    public ArrayList<Book> findBooksByAuthor(String a){
        ArrayList<Book> byAuthor = new ArrayList<>();
        for(Elem elem: elements){
            if(elem.getClass().equals(Book.class) && ((Book) elem).getAuthor().equals(a)){
                byAuthor.add((Book) elem);
            }
        }
        return byAuthor;
    }

    public ArrayList<Elem> findByTitle(String title){
        ArrayList<Elem> byTitle = new ArrayList<>();
        for(Elem elem: elements){
            if(elem.getName().equals(title)){
                byTitle.add(elem);
            }
        }
        return byTitle;
    }

    public Place findElementPlace(Elem element){
        return element.getPlace();
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Elem elem : elements) {
            txt.append(elem.toString());
        }
        return txt.toString();
    }
}
