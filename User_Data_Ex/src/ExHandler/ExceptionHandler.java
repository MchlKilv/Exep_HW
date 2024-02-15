package ExHandler;

import Intefaces.iExceptionHandler;

public class ExceptionHandler implements iExceptionHandler {

    @Override
    public void handleException(Exception e) {
        System.err.println("Ошибка: " + e.getMessage());
        e.printStackTrace();
    }

}
