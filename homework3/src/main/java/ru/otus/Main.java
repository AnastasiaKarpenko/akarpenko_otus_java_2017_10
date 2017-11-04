package ru.otus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main(String args[]) {

        AnastasiasArrayList<String> anastasiasArrayList = new AnastasiasArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>(21);

        Collections.addAll(anastasiasArrayList, "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen", "Twenty", "Twenty one");

        System.out.println("Custom Array List: ");
        for(String s: anastasiasArrayList) {
            System.out.print(s + ", ");
        }
        System.out.println("");

        Collections.sort(anastasiasArrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("");
        System.out.println("Custom Array List is sorted alphabetically: ");
        for(String s: anastasiasArrayList) {
            System.out.print(s + ", ");
        }
        System.out.println("");


        Collections.addAll(arrayList, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14" ,
                "15", "16", "17", "18", "19", "20", "21");

        System.out.println("");
        System.out.println("Created Java Collections ArrayList: " + arrayList);
        System.out.println("");

        Collections.copy(arrayList, anastasiasArrayList);

        System.out.println("");
        System.out.println("Alphabetically Sorted custom Array List is copied to Java Collections ArrayList: " + arrayList);
        System.out.println("");
    }
}
