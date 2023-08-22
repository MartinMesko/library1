package sk.itvkurze.Lekcia_18;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String surname;
    private String dateOfBirth;  // Zmena typu z Date na String
    private int personalId;
    private List<String> rentedTitles;

    public Member(String name, String surname, String dateOfBirth, int personalId) {  // Zmena typu parametra z Date na String
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;  // Zmena typu z Date na String
        this.personalId = personalId;
        this.rentedTitles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {  // Zmena typu z Date na String
        return dateOfBirth;
    }

    public int getPersonalId() {
        return personalId;
    }

    public List<String> getRentedTitles() {
        return rentedTitles;
    }

    public void rentTitle(String title) {
        rentedTitles.add(title);
    }

    public void returnTitle(String title) {
        rentedTitles.remove(title);
    }

    @Override
    public String toString() {
        return name + " " + surname + " | Date of Birth: " + dateOfBirth + " - Personal Id: " + personalId;  // Priamo pridáme dateOfBirth, pretože už je to String
    }
}
