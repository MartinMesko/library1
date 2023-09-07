package sk.itvkurze.Lekcia_18;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    }

    public void showMembersMenu() {
        System.out.println("Members ");
        System.out.println("1 - Show All Members");
        System.out.println("2 - Add Member");
        System.out.println("3 - Remove Member");
        System.out.println("4 - Back");
        System.out.print("Choose an option: ");

        switch (LibraryApp.getValidatedChoice(4)) {
            case 1 -> showAllMembers();
            case 2 -> addMember();
            case 3 -> deleteMember();
            case 4 -> {
                LibraryApp.showMainMenu();
                goBack();
            }
            default -> showMembersMenu();
        }
    }

    public void showAllMembers() {
        listingAllMembers();

        if (totalMembersCount >= 1){
            System.out.println("Total number of all members: " + totalMembersCount);
            System.out.println(lineSeparator + "Press enter to return to Members menu...");
        } else {
            System.out.println(lineSeparator + "Member list is empty. Press enter to return to Members menu...");
        }
        scanner.nextLine();
        showMembersMenu();
    }

    public void listingAllMembers(){
        System.out.println("All Members:");
        int memberCounter = 1;

        for (Member member : members) {
            System.out.println(memberCounter + ". " + member);
            memberCounter++;
        }
    }

    public void loadMembers() {
        try {
            totalMembersCount += loadMembersFromFile(memberFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadMembersFromFile(String filePath) throws IOException {
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
                        totalMembersCount++;
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
        return totalMembersCount;
    }

    public void addMember() {
        System.out.println("Add a new member");

    }

    public void deleteMember() {

    }

    private void goBack() {
        System.out.println("Going back to main menu...");
    }
}
