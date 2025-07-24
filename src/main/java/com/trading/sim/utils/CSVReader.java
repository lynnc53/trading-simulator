package com.trading.sim.utils; // declares that the file belongs to the utils package 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.trading.sim.model.Candle; // correct import

// begin class definition for CSVReader
public class CSVReader{
    // method to read candles from a CSV file and return a list of Candle objects
    // static makes it so that we dont need to create an object to use it 
    public static List<Candle> readCandles(String filepath) {
        List<Candle> candles = new ArrayList<>(); // create a list to hold Candle objects 
        String line;
        String splitBy = ","; // Assuming CSV is comma-separated

        // opens the file and prepares to rea it 
        // try() is a safe way to open resources that will be closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // Skip the header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(splitBy);
                if (values.length == 6) {
                    LocalDate date = LocalDate.parse(values[0]);
                    double open = Double.parseDouble(values[1]);
                    double high = Double.parseDouble(values[2]);
                    double low = Double.parseDouble(values[3]);
                    double close = Double.parseDouble(values[4]);
                    double volume = Double.parseDouble(values[5]);

                    Candle candle = new Candle(date, open, high, low, close, volume); // new Candle object using the parsed values 
                    candles.add(candle); // adds candle to the list candles 
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage()); // print error message if file cannot be read 
        }

        return candles; // after whole file is read, return the full ist of candles 
    }
}