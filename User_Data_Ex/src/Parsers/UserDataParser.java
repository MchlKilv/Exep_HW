package Parsers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Data.UserData;
import Exceptions.InvalidDataFormatException;
import Intefaces.iUserDataParser;

public class UserDataParser implements iUserDataParser {

    @Override
    public UserData parseUserData(String input) throws InvalidDataFormatException, ParseException {
        Scanner scanner = new Scanner(System.in);
        UserData userData = null;
        boolean isValidInput = false;

        do {
            String[] parts = input.split(" ");
            if (parts.length != 6) {
                System.out.println("Неверное количество данных. Попробуйте снова.");
                input = scanner.nextLine();
                continue;
            }

            try {
                String lastName = validateName(parts[0], "Фамилия");
                String firstName = validateName(parts[1], "Имя");
                String middleName = validateName(parts[2], "Отчество");
                LocalDate birthDate = validateDate(parts[3], "Дата рождения");
                long phoneNumber = validatePhoneNumber(parts[4], "Номер телефона");
                char gender = validateGender(parts[5], "Пол");

                userData = new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
                isValidInput = true;
            } catch (InvalidDataFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
                if (e.getMessage().contains("Номер телефона не заполнен")) {
                    System.out.println("Необходимо заполнить номер телефона.");
                } else if (e.getMessage().contains("Дата рождения не заполнена")) {
                    System.out.println("Необходимо заполнить дату рождения.");
                } else {
                    System.out.println("Повторите ввод (или введите 'q' для выхода):");
                }

                input = scanner.nextLine();
                if (input.equals("q")) {
                    break;
                }
            }
        } while (!isValidInput);

        scanner.close();
        return userData;
    }

    private String validateName(String name, String fieldName) throws InvalidDataFormatException {
        if (name.isEmpty()) {
            throw new InvalidDataFormatException(fieldName + " не введено.");
        }
        // Дополнительные проверки, если необходимо
        return name;
    }

    private LocalDate validateDate(String dateString, String fieldName)
            throws InvalidDataFormatException, ParseException {
        if (dateString.isEmpty()) {
            throw new InvalidDataFormatException(fieldName + " не заполнена.");
        }

        try {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new InvalidDataFormatException(fieldName + " имеет неверный формат даты.");
        }
    }

    private long validatePhoneNumber(String phoneNumberString, String fieldName) throws InvalidDataFormatException {
        if (phoneNumberString.isEmpty()) {
            throw new InvalidDataFormatException(fieldName + " не заполнен.");
        }

        try {
            return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Неверный формат номера телефона.");
        }
    }

    private char validateGender(String genderString, String fieldName) throws InvalidDataFormatException {
        if (genderString.length() != 1 || (!genderString.equals("m") && !genderString.equals("f"))) {
            throw new InvalidDataFormatException("Неверный формат пола.");
        }
        return genderString.charAt(0);
    }
}