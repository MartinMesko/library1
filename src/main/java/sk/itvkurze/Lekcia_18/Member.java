package sk.itvkurze.Lekcia_18;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member {
    private String name;
    private String surname;

    private Date dateOfBirth;
    private int personalId;
    private List<String> rentedTitles;

    public Member(String name, String surname, Date dateOfBirth, int personalId) {
        this.name = name;
        this.surname = surname;

        this.dateOfBirth = dateOfBirth;
        this.personalId = personalId;
        this.rentedTitles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }



    public Date getDateOfBirth() {
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateString = dateFormat.format(dateOfBirth);

        return name + " " + surname + " | Date of Birth: " + dateString + " - Personal Id: " + personalId;
    }
}
