package sk.itvkurze.Lekcia_21;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final String surname;
    private final String dateOfBirth;
    private final int personalId;
    public List<Book> rentedTitleBook;
    public List<DVD> rentedTitleDvd;

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
        this.rentedTitleBook = new ArrayList<>();
        this.rentedTitleDvd = new ArrayList<>();
    }

    public List<Book> getRentedTitleBook() {
        return rentedTitleBook;
    }

    public void setRentedTitleBook(List<Book> rentedTitleBook) {
        this.rentedTitleBook = rentedTitleBook;
    }

    public List<DVD> getRentedTitleDvd() {
        return rentedTitleDvd;
    }

    public void setRentedTitleDvd(List<DVD> rentedTitleDvd) {
        this.rentedTitleDvd = rentedTitleDvd;
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
