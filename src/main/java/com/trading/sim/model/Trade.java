package com.trading.sim.model;

public class Trade {
    // declare attributes for the Trade class 
    private TradeDirection direction; // call TradeDirection enum for direction 
    private double entryPrice;
    private double exitPrice; 
    private int quantity;

    // constructor to initialize the Trade object with given parameters
    public Trade(TradeDirection direction, double entryPrice, double exitPrice, int quantity) {
        this.direction = direction;
        this.entryPrice = entryPrice;
        this.exitPrice = -1.0; // default value for exitPrice, can be updated later
        this.quantity = quantity;
    }

    // method to set the exit price when the trade is closed 
    public void exit(double exitPrice) {
        this.exitPrice = exitPrice; // update exitPrice when the trade is closed 
    }

    // method to calculate the profit from the trade
    public double getProfit() {
        if (exitPrice == -1.0) return 0.0; // case when trade is not exited yet
        double priceChange = (direction == TradeDirection.LONG)
                ? exitPrice - entryPrice
                : entryPrice - exitPrice; // calculate profit based on direction
        return priceChange * quantity; // return profit based on price change and quantity
    }

    // getters for the attributes
    public TradeDirection getDirection() {
        return direction;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public double getQuantity(){
        return quantity;
    }
}
