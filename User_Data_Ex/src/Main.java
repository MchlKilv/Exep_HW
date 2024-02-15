import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Data.UserData;
import ExHandler.ExceptionHandler;
import Exceptions.InvalidDataFormatException;
import Intefaces.iExceptionHandler;
import Intefaces.iUserDataParser;
import Intefaces.iUserDataSaver;
import Parsers.UserDataParser;
import Writers.UserDataSaver;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");
        String input = scanner.nextLine();

        try {
            iUserDataParser userDataParser = new UserDataParser();
            iUserDataSaver userDataSaver = new UserDataSaver();
            // iExceptionHandler exceptionHandler = new ExceptionHandler();

            UserData userData = userDataParser.parseUserData(input);
            userDataSaver.saveUserDataToFile(userData);
            System.out.println("Данные успешно сохранены в файл.");
        } catch (InvalidDataFormatException | IOException e) {
            iExceptionHandler exceptionHandler = new ExceptionHandler();
            exceptionHandler.handleException(e);
        } catch (ParseException e) {
            System.err.println("Ошибка парсинга даты: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
