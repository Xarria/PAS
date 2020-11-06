import jdk.vm.ci.meta.Local;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentManager {
    RentRepository currentRents;
    RentRepository archiveRents;

    public RentManager(RentRepository currentRents, RentRepository archiveRents) {
        this.currentRents = currentRents;
        this.archiveRents = archiveRents;
    }

    public void createRent(Renter renter, Elem element){
        if(!isRented(element)){
            Rent rent = new Rent(element, renter);
            currentRents.add(rent);
        }
        else{
            System.out.println("Element jest już wypożyczony");
        }
    }

    public boolean isRented(Elem element){
        for(Rent rent : currentRents.rentRepository){
            if(rent.getElement().equals(element)){
                return true;
            }
        }
        return false;
    }

    public void endRent(Rent rent){
        rent.endDate = LocalDate.now();
        currentRents.remove(rent);
        archiveRents.add(rent);
    }

    public void getAllRenterRents(Renter renter){
        System.out.println("Obecne wypożyczenia: ");
        ArrayList<Rent> current = currentRents.getAllRenterRents(renter);
        displayArray(current, currentRents);
        System.out.println("Archiwalne wypożyczenia: ");
        ArrayList<Rent> archive = archiveRents.getAllRenterRents(renter);
        displayArray(current, archiveRents);
    }

    public void displayArray(ArrayList<Rent> elements, RentRepository rents){
        for(Rent rent: rents.rentRepository){
            rent.toString();
        }
    }

}
