package com.library.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ElementRepository implements ElemRepoInterface {
    private ArrayList<Elem> elements;

    public ElementRepository() {
        this.elements = new ArrayList<>();
    }

    public void add(Object element) {
        Elem elem = (Elem) element;
        for (Elem e : elements) {
            if (e.getId() == elem.getId()) {
                System.out.println("Istnieje już element o danym id");
                return;
            }
        }
        elements.add(elem);
    }
//usunięcie Zasobu powinno wiązać się z ustawieniem pustej referencji jako wartości odpowiedniego atrybutu związanych z usuwanym obiektem alokacji
    public void remove(Elem elem){
        elements.set(elements.indexOf(elem), null);
    }

//listy Użytkowników oraz Zasobów powinny udostępniać możliwość filtrowania co najmniej według wartości klucza
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

    public String toString(Elem element, RentRepoInterface rentRepo) {
        StringBuilder txt = new StringBuilder();
        for (Elem elem : elements) {
            txt.append(elem.toString());
        }
        txt.append(getRentForElement(element, rentRepo));
        return txt.toString();
    }

    public String getRentForElement(Elem elem, RentRepoInterface rentRepo){
        if(rentRepo.getRentForElement(elem.getId()) != null ){
            return rentRepo.getRentForElement(elem.getId()).toString();
        }
        return "Element niewypożyczony";
    }

    public List<Elem> getElements(){
        return elements;
    }

}
