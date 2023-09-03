package sk.itvkurze.Lekcia_20_povodne;

import java.io.*;
import java.util.Scanner;
import java.util.List;

public class RentalsPage {
    private final Scanner scanner;
    private final String lineSeparator = System.lineSeparator();
    private final MembersPage membersPage;
    private final TitlesPage titlesPage;

    public RentalsPage(Scanner scanner, MembersPage membersPage, TitlesPage titlesPage) {
        this.scanner = scanner;
        this.membersPage = membersPage;
        this.titlesPage = titlesPage;
    }

    public RentalsPage(Scanner scanner) {
        this.scanner = scanner;
        this.membersPage = new MembersPage(scanner);
        this.titlesPage = new TitlesPage(scanner);
    }

    public void displayRentalsMemu() {
        System.out.println("Rentals page");
        System.out.println("1 - Rent a title");
        System.out.println("2 - Return a title");
        System.out.println("3 - Prolong the rental");
        System.out.println("4 - Show all rentals");
        System.out.println("5 - Show rentals past due");
        System.out.println("6 - Show Queue");
        System.out.println("7 - Back");
        System.out.print("Choose an option: ");

        String input = scanner.next();
        int choice;

        try {
            choice = Integer.parseInt(input);
            if (choice < 1 || choice > 7) {
                System.out.println("Please enter a number in the range from 1 to 7.");
                displayRentalsMemu();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            displayRentalsMemu();
            return;
        }

        switch (choice) {
            case 1 -> {
                scanner.nextLine();
                rentTitle();
            }
            case 2 -> {
                scanner.nextLine();
                returnItem();
            }
            case 3 -> {
                scanner.nextLine();
                prolongRental();
            }
            case 4 -> {
                scanner.nextLine();
                showAllRentals();
            }
            case 5 -> {
                scanner.nextLine();
                showRentalsPastDue();
            }
            case 6 -> {
                scanner.nextLine();
                showQueue();
            }
            case 7 -> {
                scanner.nextLine();
                LibraryApp.showMainMenu();
            }
            default -> displayRentalsMemu();
        }

    }
    private void rentTitle() {
        System.out.println("Choose a member to rent a title:");


        membersPage.showAllMembersWithoutReturn();

        System.out.print("Enter member number to select: ");
        int memberNumber = membersPage.validationCheckInt();

        if (memberNumber > 0 && memberNumber <= MembersPage.totalMembersCount) {
            Member selectedMember = MembersPage.members.get(memberNumber - 1);
            System.out.println("Selected member: " + selectedMember);


            System.out.println("Available titles for rent:");
            List<Object> availableTitles = titlesPage.getAllAvailableTitles();
            for (Object title : availableTitles) {
                System.out.println(title);
            }

        } else {
            System.out.println("Invalid member selection.");
        }
        displayRentalsMemu();
    }
    public int getAvailableCopies(int titleId) {
        int availableCopies = 0;
        try (Scanner scanner = new Scanner(new FileReader("titlesBook.txt"))) {
            int indexer = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int id = indexer;
                if (id == titleId) {
                    availableCopies = Integer.parseInt(parts[4]);
                    break;
                }
                indexer++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return availableCopies;
    }

    private void returnItem() {
        System.out.println("Return a title");

        displayRentalsMemu();
    }

    private void prolongRental() {
        System.out.println("Prolong the rental");

        displayRentalsMemu();
    }

    private void showAllRentals() {
        System.out.println("Show all rentals");

        displayRentalsMemu();
    }

    private void showRentalsPastDue() {
        System.out.println("Show rentals past due");

        displayRentalsMemu();
    }

    private void showQueue() {
        System.out.println("Show Queue");

        displayRentalsMemu();
    }

    private void goBack() {
        System.out.println("Going back...");
    }

}