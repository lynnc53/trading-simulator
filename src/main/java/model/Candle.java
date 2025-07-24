package model;
import java.time.LocalDate;
public class Candle {
	// declare attributes for the Candle class 
    private LocalDate date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;

    // constructor to initialize the Candle object with given parameters 
    public Candle(LocalDate date, double open, double high, double low, double close, double volume) {
        // assign the parameters to the attributes 
        this.date = date; 
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    // getters for the attributes
    public LocalDate getDate() {
        return date; 
    }
    public double getOpen() {
        return open; 
    }
    public double getHigh() {
        return high; 
    }
    public double getLow() {
        return low; 
    }
    public double getClose() {
        return close; 
    }
    public double getVolume() {
        return volume; 
    }
    
    // toString method to return a string representation of the Candle object 
    @Override 
    public String toString() {
        return "Candle{" +
                "date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                '}';
    }
}
