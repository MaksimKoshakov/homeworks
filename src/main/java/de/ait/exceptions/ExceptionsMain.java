package de.ait.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionsMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsMain.class);

    static int i = 0;

    public static void main(String[] args) {
        //divide(10, 0);

        //giveMeError();

        //divideTwo(10, 0);

        try {
            divideTree(10, 0);
        }
        catch (ArithmeticException exception){
            System.out.println("Делил на 0. Простите не знал !!!");
            LOGGER.error(exception.getLocalizedMessage());
        }


        //divideNew(10, 0);

        try {
            divideNew(10, 0);
        } catch (CloneNotSupportedException exception) {
            System.out.println("Делил на 0. Привет от divideNew");
            LOGGER.error(exception.getLocalizedMessage());
        }
    }

    public static void divide(int numberOne, int numberTwo) {
        int result;
        System.out.println("Запускаю метод");

        try {
            result = numberOne / numberTwo;
        } catch (ArithmeticException exception) {
            System.out.println("Зачем делишь на 0???");
            System.out.println("exception:--> " + exception.getLocalizedMessage());
            result = 0;
        }

            System.out.println(result);
            System.out.println("Завершаю метод");




    }

    public static void divideTwo(int numberOne, int numberTwo) {
        System.out.println("Запускаю метод");
        if (numberTwo == 0){
            throw new ArithmeticException("Хватит делить на 0 !!!");
        }
        int result = numberOne/numberTwo;
        System.out.println(result);
        System.out.println("Завершаю метод");

    }

    public static void divideTree(int numberOne, int numberTwo) throws ArithmeticException {
        System.out.println("Запускаю метод");
        int result = numberOne/numberTwo;
        System.out.println(result);
        System.out.println("Завершаю метод");

    }

    public static void divideNew(int numberOne, int numberTwo) throws CloneNotSupportedException {
        if (numberTwo == 0){
            throw new CloneNotSupportedException("divideNew  деление на 0");
        }

    }

    public static void giveMeError() {
        i++;

        System.out.println("ERRROR!!! " + i);

        try {
            giveMeError();
        }
        catch (StackOverflowError error){
            System.out.println("catch");
        }
    }
}
