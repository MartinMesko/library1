package sk.itvkurze.Lekcia_17;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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

    public TitlesPage() {
        this.scanner = new Scanner(System.in);
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

    public void displayTitlesMenu() {
        System.out.println("Titles ");
        System.out.println("1 - Show All Titles");
        System.out.println("2 - Add Title");
        System.out.println("3 - Remove Title");
        System.out.println("4 - Back");
        System.out.print("Choose an option: ");
        String input = scanner.nextLine();

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            displayTitlesMenu();
            return;
        }

        switch (choice) {
            case 1 -> showAllTitles();
            case 2 -> addTitle();
            case 3 -> deleteTitle();
            case 4 -> goBack();
            default -> {
                System.out.println("Please enter a number in the range from 1 to 4.");
                displayTitlesMenu();
            }
        }
    }

    private int displayTitleWithNumber(Object title, int startingNumber) {
        if (title instanceof Book) {
            Book book = (Book) title;
            System.out.println(startingNumber + ". Name: " + book.getTitle() + " - Author: " + book.getAuthorName() + " | ISBN: " + book.getIsbn() + " | Number of pages: " + book.getPageCount() + " | Available copies: " + book.getAvailableCopies());
        } else if (title instanceof DVD) {
            DVD dvd = (DVD) title;
            System.out.println(startingNumber + ". Name: " + dvd.getTitle() + " - Author: " + dvd.getAuthorName() + " - Number of chapters: " + dvd.getNumberOfTracks() + " - Length in minutes: " + dvd.getDurationInMinutes() + " | Available copies: " + dvd.getAvailableCopies());
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
        displayTitlesMenu();
    }


    public void addTitle() {
        System.out.println("Add a new title");
        System.out.println("1 - Add a book");
        System.out.println("2 - Add a DVD");
        System.out.println("3 - Back");
        System.out.print("Choose an option: ");
        String input = scanner.nextLine();

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            addTitle();
            return;
        }

        switch (choice) {
            case 1 -> addBook();
            case 2 -> addDVD();
            case 3 -> displayTitlesMenu();
            default -> {
                System.out.println("Please enter a number in the range from 1 to 3.");
                addTitle();
            }
        }
    }

    private void addBook() {
        System.out.print("Enter Author's name: ");
        String author = scanner.nextLine();
        System.out.print("Enter title name: ");
        String name = scanner.nextLine();
        System.out.print("Enter available copies: ");
        int copies = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter number of Pages: ");
        int pages = Integer.parseInt(scanner.nextLine());


        boolean result = saveTitle(new Book(author, name, isbn, pages, copies));
        if (result) {
            System.out.println("Book added succesfully..." + lineSeparator + "Press enter to continue...");
            scanner.nextLine();
            displayTitlesMenu();
        } else {
            System.out.println("Failed to add the book.");
        }
    }

    private void addDVD() {
        System.out.print("Enter Author's name: ");
        String author = scanner.nextLine();
        System.out.print("Enter title name: ");
        String name = scanner.nextLine();
        System.out.print("Enter available copies: ");
        int copies = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Length (minutes): ");
        int length = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number of chapters: ");
        int chapters = Integer.parseInt(scanner.nextLine());

        boolean result = saveTitle(new DVD(author, name, length, chapters, copies));
        if (result) {
            System.out.println("Dvd added succesfully..." + lineSeparator + "Press enter to continue...");
            scanner.nextLine();
            displayTitlesMenu();
        } else {
            System.out.println("Failed to add the DVD.");
        }
    }

    public boolean saveTitle(Object title) {
        try {
            String fileName;
            String titleString;

            if (title instanceof Book book) {
                fileName = bookFilePath;
                titleString = book.getAuthorName() + "," + book.getTitle() + "," + book.getIsbn() + "," + book.getPageCount() + "," + book.getAvailableCopies();
                books.add(book);
            } else {
                DVD dvd = (DVD) title;
                fileName = dvdFilePath;
                titleString = dvd.getAuthorName() + "," + dvd.getTitle() + "," + dvd.getNumberOfTracks() + "," + dvd.getDurationInMinutes() + "," + dvd.getAvailableCopies();
                dvds.add(dvd);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(titleString + lineSeparator);
            }
            totalTitlesCount++;

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteTitle() {
        int titleNumber = getId();

        try {
            File titlesFile = new File(bookFilePath);
            List<String> bookLines = Files.readAllLines(titlesFile.toPath(), StandardCharsets.UTF_8);

            File titlesDVDFile = new File(dvdFilePath);
            List<String> dvdLines = Files.readAllLines(titlesDVDFile.toPath(), StandardCharsets.UTF_8);

            titleNumber = validateTitleNumber(titleNumber, bookLines, dvdLines);  // validácia čísla titulu

            bookLines = deleteBookTitle(titleNumber, bookLines);  // odstránenie titulu z kníh
            dvdLines = deleteDvdTitle(titleNumber, bookLines, dvdLines);  // odstránenie titulu z DVD

            Files.write(titlesFile.toPath(), bookLines, StandardCharsets.UTF_8);
            Files.write(titlesDVDFile.toPath(), dvdLines, StandardCharsets.UTF_8);

            if (titleNumber <= bookLines.size()) {
                books.remove(titleNumber - 1);
            } else {
                dvds.remove(titleNumber - bookLines.size() - 1);
            }

            totalTitlesCount--;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Overenie platnosti vstupného čísla.
    public int validateTitleNumber(int titleNumber, List<String> bookLines, List<String> dvdLines) {
        if (titleNumber < 1 || (titleNumber > bookLines.size() && titleNumber > dvdLines.size() + bookLines.size())) {
            throw new IllegalArgumentException("Invalid title number.");
        }
        return titleNumber;
    }

    //Odstránenie titulu z kníh.
    public List<String> deleteBookTitle(int titleNumber, List<String> bookLines) {
        if (titleNumber <= bookLines.size()) {
            bookLines.remove(titleNumber - 1);
        }
        return bookLines;
    }

    //Odstránenie titulu z DVD.
    public List<String> deleteDvdTitle(int titleNumber, List<String> bookLines, List<String> dvdLines) {
        if (titleNumber > bookLines.size()) {
            dvdLines.remove(titleNumber - bookLines.size() - 1);
        }
        return dvdLines;
    }

    public int getId() {
        System.out.print("Enter the number of the title: ");
        int titleNumber = scanner.nextInt();
        scanner.nextLine();
        return titleNumber;
    }

    private void goBack() {
        System.out.println("Going back to main menu...");
    }

    public String validationCheckString() {
        String input = scanner.nextLine();
        try {
            Integer.parseInt(input);
            System.out.println("Please enter a valid value.");
            return validationCheckString();
        } catch (NumberFormatException e) {
            return input;
        }
    }

    public int validationCheckInt() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            return validationCheckInt();
        }
    }

    public String validationCheckISBN() {
        String input = scanner.nextLine();
        try {
            Long.parseLong(input);
            return input;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            return validationCheckISBN();
        }
    }
}
