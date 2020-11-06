public class Employee implements RenterType{

    @Override
    public int getMaxRentDuration() {
        return 150;
    }

    @Override
    public double getDailyPenalty() {
        return 0.5;
    }

    @Override
    public String toString(){
        return "pracownik";
    }
}
