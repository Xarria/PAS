
public class Book extends Elem{
    String author;
    double pages;

    public Book(String name, String genre, String author, double pages) {
        super(name, genre);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString(){
        return "\nKsiążka" + super.toString() + "\nautor: " + author + "\nilość stron: " + pages;
    }
}
