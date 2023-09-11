package sk.itvkurze.Lekcia_21;

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

        switch (getValidatedChoice(5)) {
            case 1 -> titlesPage.showTitlesMenu();
            case 2 -> membersPage.showMembersMenu();
            case 3 -> rentalsPage.showRentalsMemu();
            case 4 -> {
                // prejde submenu aplikácie
                showMainMenu();
            }
            case 5 -> System.out.println("Exiting application...");
            default -> showMainMenu();
        }
    }

    public static int getValidatedChoice(int numberOfCase) {
        String input = scanner.nextLine();
        try {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber < 1 || inputNumber > numberOfCase){
                System.out.println("Please enter a number in the range from 1 to " + numberOfCase);
                return getValidatedChoice(numberOfCase);
            }
            return inputNumber;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            return getValidatedChoice(numberOfCase);
        }
    }
}
