package com.trading.sim;

import java.util.List;

import com.trading.sim.model.Candle;
import com.trading.sim.model.Portfolio;
import com.trading.sim.model.Trade; // import Portfolio class 
import com.trading.sim.model.TradeDirection; // import TradeDirection enum
import com.trading.sim.utils.CSVReader; // import Trade class

public class Main {
    public static void main(String[] args) {
        // Example usage of CSVReader to read candles from a CSV file
        String filepath =  "src/main/resources/data/BTC.csv"; // specify the path to your CSV file
        List<Candle> candles = CSVReader.readCandles(filepath); // read candles from the file

        // Print the candles to verify they were read correctly
        for (Candle candle : candles) {
            System.out.println(candle);
        }

        Portfolio portfolio = new Portfolio(10000.0); // create a portfolio with $10,000 initial cash
        
        Trade trade1 = new Trade(TradeDirection.LONG, 100.0, 50, 4); // instantiate a Trade object 
        portfolio.enterTrade(trade1);
        System.out.println("cash after entry: " + portfolio.getCash());

        portfolio.exitTrade(trade1, 110.0);
        System.out.println("cash after exit: " + portfolio.getCash());
        System.out.println("Total equity: " + portfolio.geTotalEquity());

    
    }

}