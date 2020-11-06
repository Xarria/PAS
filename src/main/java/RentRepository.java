import java.util.ArrayList;

public class RentRepository {
    ArrayList<Rent> rentRepository;

    public RentRepository() {
        this.rentRepository = new ArrayList<Rent>();
    }

    public void add(Rent rent){
        rentRepository.add(rent);
    }

    public void remove(Rent rent){
        rentRepository.remove(rent);
    }

    @Override
    public String toString(){
        StringBuilder txt = new StringBuilder();
        for (Rent rent : rentRepository) {
            txt.append(rent.toString());
        }
        return txt.toString();
    }

    public ArrayList<Rent> getAllRenterRents(Renter person){
        ArrayList<Rent> renterRents = new ArrayList<Rent>();
        for (Rent rent : rentRepository) {
            if (rent.renter == person) {
                renterRents.add(rent);
            }
        }
        return renterRents;
    }

    public String getRent(Rent rent){
        for (Rent value : rentRepository) {
            if (value.equals(rent)) {
                return value.toString();
            }
        }
        return "Brak podanego wypożyczenia w repozytorium";
    }
}
