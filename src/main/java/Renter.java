import java.util.ArrayList;
import java.util.UUID;

public class Renter {
    ArrayList<Rent> rents = new ArrayList<Rent>();
    RenterType type;
    String name;
    String surname;
    UUID id;

    public Renter(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString(){
        return "\nWypożyczający o imieniu: " + name + " i nazwisku: " + surname + ", id: " + id + ", typ: " + type.toString() +
                "\nMaksymalny czas wypożyczenia: " + type.getMaxRentDuration() + ", kara dzienna: " + type.getDailyPenalty();
    }

    public String getRents(){
        String txt = "";
        for(int i = 0; i < rents.size(); i++){
            txt += rents.get(i).toString();
        }
        return txt;
    }

    public void setType(RenterType type) {
        this.type = type;
    }

    public int getMaxRentDays(){
        return type.getMaxRentDuration();
    }

    public void addRent(Rent rent){
        rents.add(rent);
    }

    public double getPenalty(){
        int days = 0;
        for(int i = 0; i < rents.size(); i++){
            days += rents.get(i).getDaysOver();
        }
        return days * type.getDailyPenalty();
    }
}
