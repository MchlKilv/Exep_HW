package Intefaces;

import java.text.ParseException;

import Data.UserData;
import Exceptions.InvalidDataFormatException;

public interface iUserDataParser {

    UserData parseUserData(String input) throws InvalidDataFormatException, ParseException;
}
