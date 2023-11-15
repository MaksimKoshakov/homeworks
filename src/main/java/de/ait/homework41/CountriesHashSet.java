package de.ait.homework41;

import java.util.HashSet;
import java.util.Set;

public class CountriesHashSet {
    public static Set<String> countriesSet = new HashSet<>();

    public static void main(String[] args) {

        countriesSet.add("США");
        countriesSet.add("Великобритания");
        countriesSet.add("Германия");
        countriesSet.add("Чехия");
        countriesSet.add("Германия");
        countriesSet.add("Франция");

        System.out.println("Размеры countriesSet (количество элементов) --> " + countriesSet.size());

        showAllCounties();

    }

    private static void showAllCounties() {
        System.out.println("Все элементы countriesSet: ");
        for (String country : countriesSet) {
            System.out.println(country);
        }

    }
}
