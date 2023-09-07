package sk.itvkurze.lekcia_20;

import java.util.Scanner;

public class RentalsPage {
    private final TitlesPage titlesPage;
    public RentalsPage(Scanner scanner) {
        this.titlesPage = new TitlesPage();
    }

    public void showRentalsMemu() {
        System.out.println("Rentals page");
        System.out.println("1 - Rent a title");
        System.out.println("2 - Return a title");
        System.out.println("3 - Prolong the rental");
        System.out.println("4 - Show all rentals");
        System.out.println("5 - Show rentals past due");
        System.out.println("6 - Show Queue");
        System.out.println("7 - Back");
        System.out.println("Choose an option: ");

        switch (LibraryApp.getValidatedChoice(7)) {
            case 1 -> rentTitle();
            case 2 -> returnItem();
            case 3 -> prolongRental();
            case 4 -> showAllRentals();
            case 5 -> showRentalsPastDue();
            case 6 -> showQueue();
            case 7 -> {
                goBack();
                LibraryApp.showMainMenu();
            }
            default -> showRentalsMemu();
        }
    }

    private void rentTitle() {
        MembersPage membersPage = new MembersPage();
        System.out.println("Choose a member to rent a title:");

        membersPage.listingAllMembers();

        System.out.print("Enter member number to select: ");
        int memberNumber = LibraryApp.getValidatedChoice(MembersPage.totalMembersCount);

        System.out.println("Selected member: " + memberNumber);

        System.out.println("Available titles for rent:");
        titlesPage.showAllTitlesWithoutReturn();

        showRentalsMemu();
    }

    private void returnItem() {
        System.out.println("Return a title");
        showRentalsMemu();
    }

    private void prolongRental() {
        System.out.println("Prolong the rental");
        showRentalsMemu();
    }

    private void showAllRentals() {
        System.out.println("Show all rentals");
        showRentalsMemu();
    }

    private void showRentalsPastDue() {
        System.out.println("Show rentals past due");
        showRentalsMemu();
    }

    private void showQueue() {
        System.out.println("Show Queue");
        showRentalsMemu();
    }

    private void goBack() {
        System.out.println("Going back...");
    }
}
