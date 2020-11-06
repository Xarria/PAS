import java.util.ArrayList;

public class RenterRepository {
    ArrayList<Renter> renters;

    public RenterRepository() {
        this.renters = new ArrayList<Renter>();
    }

    public void add(Renter renter){
        renters.add(renter);
    }

    public void remove(Renter renter){
        renters.remove(renter);
    }

}
