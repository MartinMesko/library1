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

        switch (LibraryApp.inputValidation(4)) {
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
        System.out.println("Add a new title");
        System.out.println("1 - Add a book");
        System.out.println("2 - Add a DVD");
        System.out.println("3 - Back");
        System.out.print("Choose an option: ");

        switch (LibraryApp.inputValidation(3)) {
            case 1 -> addBook();
            case 2 -> addDVD();
            case 3 -> showTitlesMenu();
            default -> addTitle();
        }
    }

    private void addBook() {
        System.out.print("Enter Author's name: ");
        String author = validationCheckString();
        System.out.print("Enter title name: ");
        String name = validationCheckString();
        System.out.print("Enter available copies: ");
        int copies = validationCheckInt();
        System.out.print("Enter ISBN: ");
        String isbn = validationCheckISBN();                // neviem ci to nechame ako String. Podla mna ISBN by malo byt long.
                                                            // Ak nechame String tak program vyhodnoti dlhe cislo ako String.
                                                            // V zneni zadania je ISBN 13 miestne cislo a nezmesti sa do int.
                                                            // Jediny sposob je zvlast metoda len kvoli ISBN na validaciu tak ako je to teraz.
                                                            // otazne je ci v dalsich lekciach niekde nebude robit podobny problem.
        System.out.print("Enter number of Pages: ");
        int pages = validationCheckInt();

        boolean result = saveTitle(new Book(name, author, isbn, pages, copies));
        if (result) {
            System.out.println("Book added succesfully..." + lineSeparator + "Press enter to continue...");
            scanner.nextLine();
            showTitlesMenu();
        } else {
            System.out.println("Failed to add the book.");
        }
    }

    private void addDVD() {
        System.out.print("Enter Author's name: ");
        String author = validationCheckString();
        System.out.print("Enter title name: ");
        String name = validationCheckString();
        System.out.print("Enter available copies: ");
        int copies = validationCheckInt();
        System.out.print("Enter Length (minutes): ");
        int length = validationCheckInt();
        System.out.print("Enter number of chapters: ");
        int chapters = validationCheckInt();

        boolean result = saveTitle(new DVD(name, author, chapters, length, copies));
        if (result) {
            System.out.println("Dvd added succesfully..." + lineSeparator + "Press enter to continue...");
            scanner.nextLine();
            showTitlesMenu();
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
        if (totalTitlesCount == 0) {
            System.out.println("No titles to remove. Press enter to return to titles...");
            scanner.nextLine();
            showTitlesMenu();
            return;
        }
        System.out.println("Remove Title Page");
        showAllTitlesWithoutReturn();

        System.out.print("Select a title to delete: ");
        int titleNumber = validationChecksTheRemovedNumber();

        try {
            File titlesFile = new File(bookFilePath);
            List<String> bookLines = Files.readAllLines(titlesFile.toPath(), StandardCharsets.UTF_8);

            File titlesDVDFile = new File(dvdFilePath);
            List<String> dvdLines = Files.readAllLines(titlesDVDFile.toPath(), StandardCharsets.UTF_8);

            if (titleNumber <= bookLines.size()) {
                bookLines = deleteBookTitle(titleNumber - 1, bookLines);  // odstránenie titulu z kníh
                Files.write(titlesFile.toPath(), bookLines, StandardCharsets.UTF_8);
                books.remove(titleNumber - 1);
            } else {
                dvdLines = deleteDvdTitle(titleNumber - 1, bookLines, dvdLines);  // odstránenie titulu z DVD
                Files.write(titlesDVDFile.toPath(), dvdLines, StandardCharsets.UTF_8);
                dvds.remove(titleNumber - bookLines.size() - 1);
            }

            totalTitlesCount--;
            System.out.println("Title removed successfully!" + lineSeparator + "Press enter to continue...");
            scanner.nextLine();
            showTitlesMenu();

        } catch (IOException e) {
            System.out.println("Title not removed.");
            e.printStackTrace();
        }
    }

    public void showAllTitlesWithoutReturn() {
        System.out.println("All titles:");
        int titleCounter = 1;

        for (Book book : books) {
            titleCounter = displayTitleWithNumber(book, titleCounter);
        }
        for (DVD dvd : dvds) {
            titleCounter = displayTitleWithNumber(dvd, titleCounter);
        }

        System.out.println("Total number of all titles: " + totalTitlesCount);
    }

    //Odstránenie titulu z kníh.
    public List<String> deleteBookTitle(int titleNumber, List<String> bookLines) {
        if (titleNumber <= bookLines.size()) {
            bookLines.remove(titleNumber);
        }
        return bookLines;
    }

    //Odstránenie titulu z DVD.
    public List<String> deleteDvdTitle(int titleNumber, List<String> bookLines, List<String> dvdLines) {
        if (titleNumber > bookLines.size()) {
            dvdLines.remove(titleNumber - bookLines.size());
        }
        return dvdLines;
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

    public int validationChecksTheRemovedNumber() {
        while (true) {
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= totalTitlesCount) {
                    return choice;
                } else {
                    System.out.println("Please enter a number in the range from 1 to " + totalTitlesCount);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid value.");
            }
        }
    }
}
