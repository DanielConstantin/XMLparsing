package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CSVReader {
    public static final String delimiter = ";";

    public static void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);

                Produse.mapProduse.put(tempArr[0],  new Produse(tempArr[0],tempArr[1],new BigDecimal(tempArr[2]),new BigDecimal(tempArr[3]), new BigDecimal(tempArr[4]), new BigDecimal(tempArr[5])));
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
