package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable {

    private final String id;
    private LocalTime rentingTime;
    private int pricePerMinute;

    public Car(String id, int price) {
        this.id = id;
        this.pricePerMinute = price;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes*pricePerMinute;
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime = time;
    }

    @Override
    public void closeRent() {
        rentingTime=null;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    public String getId() {
        return id;
    }

    public int getPricePerMinute() {
        return pricePerMinute;
    }
}
