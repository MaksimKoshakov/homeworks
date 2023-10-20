package de.ait.homework38;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UniqueNamesApp {
    public static void main(String[] args) {
        String input;
        Set<String> names = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите имена по очереди, для остановки напишите 'Stop'");


        do {
            input = scanner.nextLine();
            if (!input.equals("Stop")) {
                names.add(input);
            }
        }
        while (!input.equals("Stop"));
        System.out.println("Программа остановлена");

        Iterator<String> iterator = names.iterator();
        System.out.println("Уникальные имена: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

