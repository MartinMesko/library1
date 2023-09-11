package sk.itvkurze.lekcia_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TitlesPage {
    private final Scanner scanner;
    public static final List<Book> books = new ArrayList<>();
    public static final List<DVD> dvds = new ArrayList<>();
    private final String lineSeparator = System.lineSeparator();
    public static int totalTitlesCount = 0;
    public static final String bookFilePath = "titlesBook.txt";
    public static final String dvdFilePath = "titlesDVD.txt";

    public TitlesPage(Scanner scanner) {
        this.scanner = scanner;
        loadTitles();
    }

    public static int loadTitlesFromFile(String filePath, String type) throws IOException {
        int addedTitlesCount = 0;
        BufferedReader reader = null;
        try {
            File titlesFile = new File(filePath);
            reader = new BufferedReader(new FileReader(titlesFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                try {
                    if (type.equals("Book") && parts.length >= 5) {
                        books.add(new Book(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                        addedTitlesCount++;
                    } else if (type.equals("DVD") && parts.length >= 5) {
                        int duration = Integer.parseInt(parts[2]);
                        int numberOfTracks = Integer.parseInt(parts[3]);
                        int availableCopies = Integer.parseInt(parts[4]);
                        dvds.add(new DVD(parts[0], parts[1], duration, numberOfTracks, availableCopies));
                        addedTitlesCount++;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing number from line: " + line);
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        totalTitlesCount += addedTitlesCount;
        return addedTitlesCount;
    }

    public void loadTitles() {
        try {
            totalTitlesCount += loadTitlesFromFile(bookFilePath, "Book");
            totalTitlesCount += loadTitlesFromFile(dvdFilePath, "DVD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTitlesMenu() {
        System.out.println("Titles ");
        System.out.println("1 - Show All Titles");
        System.out.println("2 - Add Title");
        System.out.println("3 - Remove Title");
        System.out.println("4 - Back");
        System.out.print("Choose an option: ");

        switch (LibraryApp.getValidatedChoice(4)) {
            case 1 -> showAllTitles();
            case 2 -> addTitle();
            case 3 -> deleteTitle();
            case 4 -> {
                goBack();
                LibraryApp.showMainMenu();
            }
            default -> showTitlesMenu();
        }
    }

    private int displayTitleWithNumber(Object title, int startingNumber) {
        if (title instanceof Book book) {
            System.out.println(startingNumber + book.toString());
        } else if (title instanceof DVD dvd) {
            System.out.println(startingNumber + dvd.toString());
        }
        return startingNumber + 1;
    }

    public void showAllTitles() {
        System.out.println("All Titles:");
        int titleCounter = 1;

        for (Book book : books) {
            titleCounter = displayTitleWithNumber(book, titleCounter);
        }
        for (DVD dvd : dvds) {
            titleCounter = displayTitleWithNumber(dvd, titleCounter);
        }

        System.out.println("Total number of all titles: " + totalTitlesCount);
        System.out.println(lineSeparator + "Press enter to return to Titles menu...");
        scanner.nextLine();
        showTitlesMenu();
    }

    public void addTitle() {
        // TODO: Implementuj metodu pridaj titul
    }

    public void deleteTitle() {
        // TODO: Implementuje metodu zmazania
    }

    public void goBack() {
        System.out.println("Going back to main menu...");
    }
}
