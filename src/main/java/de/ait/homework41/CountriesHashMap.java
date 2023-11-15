package de.ait.homework41;

import java.util.HashMap;
import java.util.Map;

public class CountriesHashMap {

    private static Map<String,String> capitalMap = new HashMap<>();
    public static void main(String[] args) {

        capitalMap.put("Чехия", "Прага");
        capitalMap.put("США", "Вашингтон");
        capitalMap.put("Великобритания", "Лондон");
        capitalMap.put("Франция", "Париж");
        capitalMap.put("Германия", "Берлин");

        System.out.println("Размеры capitalMap(количество элементов) --> " + capitalMap.size());

        showCapitalMap();

        capitalMap.replace("США", "Сан-Франциско");

        showCapitalMap();

        if (!checkCountry("Испания")){
            addNewCountry("Испания", "Мадрид");
        }

        showCapitalMap();

        addNewCountry("Испания", "Мадрид");



    }

    private static void showCapitalMap(){
        System.out.println("Все элементы capitalMap: ");
        capitalMap.forEach((key,value) -> System.out.println(key + "-" + value));
    }

    private static boolean checkCountry(String countryNameKey){
        return capitalMap.containsKey(countryNameKey);
    }

    private static boolean addNewCountry (String countryNameKey, String coutryNameValue){
        if (!checkCountry(countryNameKey)){
            capitalMap.put(countryNameKey,coutryNameValue);
            System.out.println("Страна " + countryNameKey + " со столицей " + coutryNameValue + " была успешно добавлена");
            return true;
        }
        else {
            System.out.println("Страна " + countryNameKey + " найдена");
            return false;
        }
    }

}
