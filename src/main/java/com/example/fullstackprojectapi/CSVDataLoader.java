package com.example.fullstackprojectapi;

import java.awt.*;
import java.io. * ;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVDataLoader {
    public static void updateSQL() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("..\\full-stack-project-site\\src\\data\\data.csv"));
        ArrayList<String> data = new ArrayList();
        sc.useDelimiter("");
        while (sc.hasNextLine()) {
            data.add(sc.nextLine().replaceAll(",",";"));
        }
        System.out.println(data.toArray()[data.toArray().length-1]);



        sc.close();
    }
}
