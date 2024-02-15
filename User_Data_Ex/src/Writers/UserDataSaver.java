package Writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Data.UserData;
import Intefaces.iUserDataSaver;

public class UserDataSaver implements iUserDataSaver {

    @Override
    public void saveUserDataToFile(UserData userData) throws IOException {
        String fileName = userData.lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userData.toString());
            writer.newLine();
        }
    }
}
