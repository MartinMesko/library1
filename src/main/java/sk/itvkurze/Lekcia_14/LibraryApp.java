package sk.itvkurze.Lekcia_14;

import java.util.Scanner;

public class LibraryApp {
    private static final Scanner scanner = new Scanner(System.in);

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
            case 1, 2, 3, 4 -> {

                showMainMenu(); // Návrat do hlavnej ponuky po dokončení aktuálnej operácie
            }
            // prejde submenu aplikácie

            case 5 -> System.out.println("Exiting application...");
            default -> showMainMenu();
        }
    }

    public static int getValidatedChoice(int numberOfCase) {
        String input = scanner.nextLine();
        try {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber < 1 || inputNumber > numberOfCase) {
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

//Test
