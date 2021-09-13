package com.binar.binar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String arraysaya[] ={"a","b","c"};

        List<String> stringList = new ArrayList<String>(Arrays.asList(arraysaya));

        System.out.println(stringList.contains("a"));
        System.out.println(Collections.binarySearch(stringList, "b")); // mencari index array
        System.out.println(Collections.binarySearch(stringList, "Robin"));

        String searchedValue = "d";
        boolean found = false;
        for(String x : arraysaya){
            if(x.equals(searchedValue)){
                found = true;
                break;
            }
        }
        System.out.println(found);
    }

    public void serviceBus() {
        System.out.println("Kucing");
        serviceALL();
    }
    public void serviceCar() {
        System.out.println("Ayam");
        serviceALL();
    }
    public void serviceALL() {
        System.out.println("Hewan");
    }
}
