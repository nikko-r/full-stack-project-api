package com.example.fullstackprojectapi;

import java.awt.*;
import java.io. * ;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVDataLoader {
    public static void updateSQL() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("..\\full-stack-project-site\\src\\data\\data.csv"));
        //parsing a CSV file into the constructor of Scanner class
        //sc.
        ArrayList<String> data = new ArrayList();
        sc.useDelimiter("");
        //setting comma as delimiter pattern
//        System.out.println(sc.toString());
        while (sc.hasNextLine()) {
//            System.out.print(sc.nextLine());
            data.add(sc.nextLine().replaceAll(",",";"));
        }
//        System.out.println(data);
        System.out.println(data.toArray()[data.toArray().length-1]);
        sc.close();
//        System.out.println(data);
        //closes the scanner
    }

    public static void main(String[] args) throws Exception {
        updateSQL();
    }
}
