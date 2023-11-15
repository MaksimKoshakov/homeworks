package de.ait.homework47;

import de.ait.exceptions.WrongArgumentsException;
import de.ait.homework46.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Scanner;

public class UserPassValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserPassValidator.class);
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите имя пользователя или 'exit' для выхода:");
        boolean validateResult = false;

        while (!validateResult) {

            try {

                String userName = scanner.nextLine();
                userName.charAt(0);
                System.out.println("Username: " + userName);
                if (userName.equals("exit")){
                    break;
                }
                System.out.println("Введите пароль: ");
                String password = scanner.next();
                boolean result = validatePassword(password);
                if (result) {
                    System.out.println("Аккаунт успешно создан");
                    LOGGER.info("User account was created {}", userName);
                    validateResult = true;
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Имя пользователя не может быть пустым");
                LOGGER.error("User ist empty" + exception);
            }
        }
        scanner.close();
    }

    private static boolean validatePassword(String password) {
        try {
            if (password.length() < 8 || !(password.contains("@") || password.contains("!") || password.contains("#"))
                    || !password.matches(".*\\d*.")) {
                throw new WrongArgumentsException("Password length must be 8 symbol " +
                        "and include one number and special character");
            }
            else {
                return true;
            }
        } catch (WrongArgumentsException exception) {
            LOGGER.error("Password is wrong: {}", password, exception);
            System.out.println("Ошибка: пароль должен быть не менее 8 символов  и " + "содержать хотя бы одну цифру и одни специальный символ.");
            return false;
        }
    }
}
