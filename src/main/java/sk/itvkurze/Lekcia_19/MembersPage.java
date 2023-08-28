package sk.itvkurze.Lekcia_19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MembersPage {
    private final Scanner scanner;
    public static final List<Member> members = new ArrayList<>();
    private static final String lineSeparator = System.lineSeparator();
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

    public void loadMembers() {
        try {
            totalMembersCount += loadMembersFromFile(memberFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadMembersFromFile(String filePath) throws IOException {
        int addedMembersCount = 0;
        BufferedReader reader = null;
        try {
            File membersFile = new File(filePath);
            reader = new BufferedReader(new FileReader(membersFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                try {
                    if (parts.length >= 3) {
                        members.add(new Member(parts[0].trim(), parts[1].trim(), parts[2].trim(), Integer.parseInt(parts[3].trim())));
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
            System.out.println(memberCounter + ". " + member);
            memberCounter++;
        }

        System.out.println("Total number of all members: " + totalMembersCount);
        System.out.println(lineSeparator + "Press enter to return to Members menu...");
        scanner.nextLine();
        displayMembersMenu();
    }

    public void addMember() {
        System.out.println("Add a new member");
        System.out.print("Enter member's first name: ");
        String name = validationCheckString();
        System.out.print("Enter member's last name: ");
        String surname = validationCheckString();
        System.out.print("Enter Member's date of birth (dd.mm.yyyy): ");
        String dateOfBirth = validateDateOfBirthInput();
        System.out.print("Enter Member's personal id: ");
        int personalId = validationCheckInt();

        boolean result = saveMember(new Member(name, surname, dateOfBirth, personalId));
        if (result) {
            System.out.println("Member added successfully" + lineSeparator + "Press enter to return to Members page...");
            scanner.nextLine();
            displayMembersMenu();
        } else {
            System.out.println("Failed to add the member.");
        }
    }

    public static boolean saveMember(Member member) {
        try {
            String memberString = member.getName() + "," + member.getSurname() + "," + member.getDateOfBirth() + "," + member.getPersonalId();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(memberFilePath, true))) {
                writer.write(memberString + lineSeparator);
            }
            totalMembersCount++;
            members.add(member);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteMember() {
        if (totalMembersCount == 0) {
            System.out.println("No members to remove. Press enter to return to Members page...");
            scanner.nextLine();
            displayMembersMenu();
            return;
        }

        System.out.println("Remove member page");
        System.out.print("Choose a member to delete:" + lineSeparator);
        showAllMembersWithoutReturn();
        System.out.println("Choose an option:");

        int memberNumber = validationChecksTheRemovedMember();

        /*
        int memberNumber;
        try {
            memberNumber = validationCheckInt();
            if (memberNumber < 1 || memberNumber > totalMembersCount) {
                System.out.println("Please enter a number in the range from 1 to " + totalMembersCount + ".");
                deleteMember();
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please try again.");
            deleteMember();
            return;
        }
         */

        try {
            File membersFile = new File(memberFilePath);
            List<String> memberLines = Files.readAllLines(membersFile.toPath(), StandardCharsets.UTF_8);

            memberLines.remove(memberNumber - 1);
            Files.write(membersFile.toPath(), memberLines, StandardCharsets.UTF_8);

            members.remove(memberNumber - 1);

            totalMembersCount--;
            System.out.println("Member deleted successfully." + lineSeparator + "Press enter to return to Members page...");
            scanner.nextLine();
            displayMembersMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showAllMembersWithoutReturn() {
        System.out.println("All Members:");
        int memberCounter = 1;

        for (Member member : members) {
            memberCounter = displayMemberWithNumber(member, memberCounter);
        }

        System.out.println("Total number of all members: " + totalMembersCount);
    }


    private int displayMemberWithNumber(Member member, int memberCounter) {
        System.out.println(memberCounter + ". " + member.toString());
        return memberCounter + 1;
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

    private String validateDateOfBirthInput() {
        String userInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(userInput, formatter);
            return userInput;
        } catch (DateTimeParseException e) {
            System.out.println("Please enter a valid value.");
            return validateDateOfBirthInput();
        }
    }

    public int validationChecksTheRemovedMember() {
        String input = scanner.nextLine();
        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= totalMembersCount) {
                return choice;
            } else {
                System.out.println("Please enter a number in the range from 1 to " + totalMembersCount);
                return validationChecksTheRemovedMember();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid value.");
            return validationChecksTheRemovedMember();
        }
    }
}
