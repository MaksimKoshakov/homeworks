package de.ait.homework46;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ArrayUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayUtil.class);

    private static String[] arrayCar = {"Audi", "BMW", "VW", "MB", "Seat"};

    public static void main(String[] args) {

        boolean resultExact = false;
        Scanner scanner = new Scanner(System.in);
        while (!resultExact) {
            System.out.println("Введите индекс элемента для извлечения: ");
            try {
            String input = scanner.nextLine();
            int element = Integer.parseInt(input);
                String elementValue = arrayCar[element];
                LOGGER.info("Извлеченный элемент: {}", elementValue);
                resultExact=true;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
                LOGGER.error("Ошибка.", exception);
            } catch (Exception exception){
                LOGGER.error("Неизвестная ошибка", exception);
            } finally {
                LOGGER.info("Операция завершена.");
            }
        }
        scanner.close();
    }
}
