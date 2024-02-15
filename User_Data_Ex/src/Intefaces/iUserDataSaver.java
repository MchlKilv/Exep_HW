package Intefaces;

import java.io.IOException;

import Data.UserData;

public interface iUserDataSaver {
    void saveUserDataToFile(UserData userData) throws IOException;
}
