package sk.itvkurze.Lekcia_18;

public class Member {
    private String name;
    private String surname;
    private String dateOfBirth;
    private int personalId;

    public Member(String name, String surname, String dateOfBirth, int personalId) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.personalId = personalId;

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
        return name + " " + surname + " | Date of Birth: " + dateOfBirth + " - Personal Id: " + personalId;
    }


}
