package de.ait.homework41;

import java.util.ArrayList;
import java.util.List;

public class CountriesArrayList {
    private static List<String> countriesList = new ArrayList<>();

    public static void main(String[] args) {

        countriesList.add("США");
        countriesList.add("Великобритания");
        countriesList.add("Франция");
        countriesList.add("Чехия");
        countriesList.add("Германия");
        countriesList.add("Франция");

        System.out.println("Размеры countriesList --> " + countriesList.size());

        showAllCounties();

        removeDublicates();
        showAllCounties();


    }

    private static void showAllCounties() {
        System.out.println("Все элементы countriesList: ");
        for (String country : countriesList) {
            System.out.println(country);
        }

    }

    private static void removeDublicates(){
        List<String> uniqueCountries = new ArrayList<>();

        for (String country : countriesList){
            if (!uniqueCountries.contains(country)) {
                uniqueCountries.add(country);
            }
        }
        countriesList = new ArrayList<>(uniqueCountries);
        System.out.println("Дубликаты были удалены");
    }

}
