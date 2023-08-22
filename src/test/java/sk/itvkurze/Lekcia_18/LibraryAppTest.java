package sk.itvkurze.Lekcia_18;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryAppTest {

    private static final String TEST_FILE_PATH = "membersTest.txt";

    @BeforeEach
    void setUp() throws IOException {
        List<String> lines = List.of(
                "John|Doe|01/01/2000|123456",
                "Jane|Smith|02/02/2001|654321"
        );
        Files.write(Paths.get(TEST_FILE_PATH), lines);
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    }

    @Test
    void testLoadMembersFromFile() throws IOException {
        int loadedMembers = MembersPage.loadMembersFromFile(TEST_FILE_PATH);

        // Overenie, či sa načítal správny počet členov
        assertEquals(2, loadedMembers);
        assertEquals(2, MembersPage.members.size());

        // Overenie, či prvý člen v ArrayListe má správne hodnoty
        Member firstMember = MembersPage.members.get(0);
        assertEquals("John", firstMember.getName());
        assertEquals("Doe", firstMember.getSurname());

    }
}
