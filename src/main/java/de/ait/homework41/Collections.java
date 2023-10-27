package de.ait.homework41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collections {
    public static void main(String[] args) {

        //ArrayList
        System.out.println("-----ArrayList------");

        //Создаем лист и добавляем в него элементы
        List<String> countriesList = new ArrayList<>();
        countriesList.add("США");
        countriesList.add("Великобритания");
        countriesList.add("Франция");
        countriesList.add("Чехия");
        countriesList.add("Германия");
        countriesList.add("Франция");

        //Выводим размер листа
        System.out.println("Размер листа: " + countriesList.size());

        //Выводим элементы в исходном виде
        System.out.println("Элементы countriesList в исходном порядке:");
        for (String allElements : countriesList) {
            System.out.println(allElements);
        }

        //Используем HashSet для удаления дубликатов
        Set<String> uniqueCountries = new HashSet(countriesList);
        countriesList.clear();
        countriesList.addAll(uniqueCountries);

        //Выводим элементы countriesList после удаления дубликатов
        System.out.println("Элементы countriesList после удаления дубликатов:");
        for (String country : countriesList) {
            System.out.println(country);
        }

        //HashSet
        System.out.println("-----HashSet------");

        //Создаем HashSet и добавляем в него элементы countriesList
        Set<String> countriesSet = new HashSet<>(countriesList);

        //Выводим размер HashSet
        System.out.println("Размер HashSet: " + countriesSet.size());

        //Выводим все элементы HashSet
        System.out.println("Элементы countriesSet:");
        for (String getAllElements : countriesSet) {
            System.out.println(getAllElements);
        }


        //HashMap
        System.out.println("-----HashMap-----");

        //Создаем HashMap и добавляем в него элементы
        Map<String, String> capitalMap = new HashMap<>();
        capitalMap.put("Чехия", "Прага");
        capitalMap.put("США", "Вашингтон");
        capitalMap.put("Великобритания", "Лондон");
        capitalMap.put("Франция", "Париж");
        capitalMap.put("Германия", "Берлин");

        //Выводим пары 'страна-столица' через вызов отдельно key и value
        System.out.println("Пары 'страна-столица:'");
        for (Map.Entry<String, String> result : capitalMap.entrySet()) {
            System.out.println(result.getKey() + " - " + result.getValue());
        }

        //Замена столицы США с Вашингтон на Сан-Франциско
        capitalMap.put("США", "Сан-Франциско");

        System.out.println("Список пар 'страна-столица' после замены столицы США");

        //Вывод пары 'страна-столица' с помощью Iterator
        Iterator<Map.Entry<String, String>> getResult = capitalMap.entrySet().iterator();
        while (getResult.hasNext()) {
            System.out.println(getResult.next());
        }
        //Проверяем содержит ли countriesSet элемент "Испания" и если нет, то добавляем Испания - Мадрид в capitalMap
        if (!countriesSet.contains("Испания")) {
            capitalMap.put("Испания", "Мадрид");
        }
        //Вывод пары 'страна-столица' после добавления
        System.out.println("Список пар 'страна-столица' после добавления Испании");
        for (Map.Entry<String, String> resultAfterAdd : capitalMap.entrySet()) {
            System.out.println(resultAfterAdd.getKey() + "-" + resultAfterAdd.getValue());
        }
    }
}
