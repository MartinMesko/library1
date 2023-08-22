package sk.itvkurze.Lekcia_18;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembersPage {
    private final Scanner scanner;
    public static final List<Member> members = new ArrayList<>();
    private final String lineSeparator = System.lineSeparator();
    public static int totalMembersCount = 0;
    public static final String memberFilePath = "members.txt";

    public MembersPage(Scanner scanner) {
        this.scanner = scanner;
        loadMembers();
    }

    public MembersPage() {
        this.scanner = new Scanner(System.in);
        loadMembers();
    }

    public static int loadMembersFromFile(String filePath) throws IOException {
        int addedMembersCount = 0;
        BufferedReader reader = null;
        try {
            File membersFile = new File(filePath);
            reader = new BufferedReader(new FileReader(membersFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                try {
                    if (parts.length >= 3) {
                        members.add(new Member(parts[0].trim(), parts[1].trim(), parts[2].trim(), Integer.parseInt(parts[3].trim()))); // Adjusted here. No need for SimpleDateFormat anymore

                        addedMembersCount++;
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
        totalMembersCount += addedMembersCount;
        return addedMembersCount;
    }

    public void loadMembers() {
        try {
            totalMembersCount += loadMembersFromFile(memberFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMembersMenu() {
        System.out.println("Members ");
        System.out.println("1 - Show All Members");
        System.out.println("2 - Add Member");
        System.out.println("3 - Remove Member");
        System.out.println("4 - Back");
        System.out.print("Choose an option: ");
        String input = scanner.nextLine();

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            displayMembersMenu();
            return;
        }

        switch (choice) {
            case 1 -> showAllMembers();
            case 2 -> addMember();
            case 3 -> deleteMember();
            case 4 -> goBack();
            default -> {
                System.out.println("Please enter a number in the range from 1 to 4.");
                displayMembersMenu();
            }
        }
    }

    public void showAllMembers() {
        System.out.println("All Members:");
        int memberCounter = 1;

        for (Member member : members) {
            System.out.println(memberCounter + ". Name: " + member.getName() + " - Surname: " + member.getSurname() + " - Date of Birth: " + member.getDateOfBirth() + " - Personal ID: " + member.getPersonalId());

            memberCounter++;
        }

        System.out.println("Total number of all members: " + totalMembersCount);
        System.out.println(lineSeparator + "Press enter to return to Members menu...");
        scanner.nextLine();
        displayMembersMenu();
    }

    public void addMember() {
        System.out.println("Add a new member");

    }

    public boolean saveMember(Member member) {

        return false;
    }

    public void deleteMember() {

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
}
