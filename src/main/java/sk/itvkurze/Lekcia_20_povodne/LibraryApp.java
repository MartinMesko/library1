package sk.itvkurze.Lekcia_20_povodne;

import java.util.Scanner;

public class LibraryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TitlesPage titlesPage = new TitlesPage(scanner);
    private static final MembersPage membersPage = new MembersPage(scanner);
    private static final RentalsPage rentalsPage = new RentalsPage(scanner);
    public static void main(String[] args) {
        System.out.println(">>>> Welcome to our Library <<<<");
        showMainMenu();
    }

    public static void showMainMenu() {
        System.out.println("1 - Titles");
        System.out.println("2 - Members");
        System.out.println("3 - Rentals");
        System.out.println("4 - Messages");
        System.out.println("5 - Exit");
        System.out.print("Choose an option: ");

        int choice = getChoice();

        switch (choice) {
            case 1 -> {
                titlesPage.displayTitlesMenu();
                showMainMenu();
            }
            case 2 -> {
                membersPage.displayMembersMenu();
                showMainMenu();
            }

            case 3 -> {
                rentalsPage.displayRentalsMemu();
                showMainMenu();


            }
            case 4 -> {

                showMainMenu();
            }

            case 5 -> System.out.println("Exiting application...");
            default -> {
                System.out.println("Please enter a number in the range from 1 to 5");
                showMainMenu();
            }
        }
    }

    public static int getChoice() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            return getChoice();
        }
    }
}
