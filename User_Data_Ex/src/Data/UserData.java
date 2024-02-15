package Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserData {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public String lastName;
    String firstName;
    String middleName;
    LocalDate birthDate;
    long phoneNumber;
    char gender;

    public UserData(String lastName, String firstName, String middleName, LocalDate birthDate, long phoneNumber,
            char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("<%s> <%s> <%s> <%s> <%d> <%c>", lastName, firstName, middleName,
                birthDate.format(FORMATTER), phoneNumber,
                gender);
    }
}
