package sk.itvkurze.Lekcia_20;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class LibraryAppTest {

    @Test
    void whenMemberIsAddedThenMembersFileIsNotEmpty() throws Exception {
        Member member = new Member("Juraj", "Kukura", "10.10.1951", 123456);
        MembersPage.saveMember(member);
        File membersFile = new File(MembersPage.memberFilePath);
        assertTrue(membersFile.exists(), "File members.txt should exist");
        assertTrue(Files.size(membersFile.toPath()) > 0, "File members.txt should not be empty");
    }

    @Test
    void whenValidInputIsGivenThenReturnCorrectChoice() {
        setInput("1\n");
        int choice = LibraryApp.getValidatedChoice(7);
        assertEquals(1, choice);

    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}