public class Student implements RenterType {
    @Override
    public int getMaxRentDuration() {
        return 60;
    }

    @Override
    public double getDailyPenalty() {
        return 0.75;
    }

    @Override
    public String toString(){
        return "student";
    }
}
