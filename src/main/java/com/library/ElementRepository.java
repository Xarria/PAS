package com.library;

import java.util.ArrayList;

public class ElementRepository {
    private ArrayList<Elem> elements;

    public ElementRepository() {
        this.elements = new ArrayList<>();
    }

    public void add(Elem elem){
        elements.add(elem);
    }

    public void remove(Elem elem){
        elements.remove(elem);
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
}
