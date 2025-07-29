package com.trading.sim.model;
import java.util.ArrayList;
import java.util.List;


public class Portfolio {
    // declare attributes for the Portfolio class 
    private double cash;
    private List<Trade> openTrades; // list calling Trade class for open trades 

    // constructor to initialize the Porfolio object with initial cash 
    public Portfolio(double initialCash) {
        this.cash = initialCash;
        this.openTrades = new ArrayList<>(); // initialize list of open trades using ArrayList
    }

    // method received a trade object and enters the trade into the portfolio and calculates the cash balance 
    public void enterTrade(Trade trade) {
        double cost = trade.getQuantity() * trade.getEntryPrice();
        if (trade.getDirection() == TradeDirection.LONG) {
            cash -= cost; // if long trade, deduct cost form cash
        } else {
            cash += cost; // if short trade, add cost to cash 
        }
        openTrades.add(trade); // add the trade to the list of open trades
    }

    public void exitTrade(Trade trade, double exitPrice) {
        trade.exit(exitPrice); // call exit method on the trade to set exit price
        double profit = trade.getProfit(); // calculate profit from the trade
        cash += profit; // update cash balance with profit or loss
        openTrades.remove(trade); // remove the trade from the list of open trades
    }

    // getters for the attributes
    // public method returning the total equity of the portfolio
    public double geTotalEquity() {
        return cash;
    }

    // public method returning the current cash balance 
    public double getCash() {
        return cash;
    }

    // public method returning a list of open trades
    public List<Trade> getOpenTrades() {
        return openTrades;
    }
}
