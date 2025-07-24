package com.trading.sim;

import java.util.List;

import com.trading.sim.model.Candle;
import com.trading.sim.utils.CSVReader;


public class Main {
    public static void main(String[] args) {
        // Example usage of CSVReader to read candles from a CSV file
        String filepath =  "src/main/resources/data/BTC.csv"; // specify the path to your CSV file
        List<Candle> candles = CSVReader.readCandles(filepath); // read candles from the file

        // Print the candles to verify they were read correctly
        for (Candle candle : candles) {
            System.out.println(candle);
        }
    }
}