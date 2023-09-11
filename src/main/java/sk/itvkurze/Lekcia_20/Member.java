package sk.itvkurze.Lekcia_20;

public class Member {
    private final String name;
    private final String surname;
    private final String dateOfBirth;
    private final int personalId;

    public Member(String name, String surname, String dateOfBirth, int personalId) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.personalId = personalId;
    }

    public Member() {
        this.name = "";
        this.surname = "";
        this.dateOfBirth = "";
        this.personalId = 0;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPersonalId() {
        return personalId;
    }

    @Override
    public String toString() {
        return name + " " +
                surname + " | Date of Birth: " +
                dateOfBirth + " - Personal Id: " +
                personalId;
    }
}
