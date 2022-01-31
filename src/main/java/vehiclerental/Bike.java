package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable{

    private final String id;
    private LocalTime rentingTime;
//    private static final int PRISE_PER_MINUTE = 15;

    public Bike(String id) {
        this.id = id;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) (minutes*15);
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime=time;
    }

    @Override
    public void closeRent() {
        rentingTime=null;
    }

    public String getId() {
        return id;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }
}
