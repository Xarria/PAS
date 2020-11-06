import java.util.UUID;

public class Elem {
    String name;
    String genre;
    UUID id;
    Place place;

    public Elem(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString(){
        return ", tytuł: " + name + "\ngatunek: " + genre + "\nID: " + id + "\nRegał: " + place.rack + ", pozycja: " + place.position;
    }

    public void setPlace(Place newPlace){
        this.place = newPlace;
    }
}
