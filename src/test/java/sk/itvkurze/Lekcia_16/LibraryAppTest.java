package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LibraryAppTest {

    private File testFile;

    @BeforeEach
    public void setUp() {
        testFile = new File("testFile.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFile))) {
            writer.write("Author,Title,100,ISBN001,5,10");
            writer.newLine();
            // Pridaj ďalšie riadky podľa potreby, keď budeš vytvárať ďalšie testy
        } catch (IOException e) {
            fail("Chyba pri vytváraní testovacieho súboru: " + e.getMessage());
        }

    }

    @AfterEach
    public void tearDown() {
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void whenFileExistThenTestPasses() {

        assertTrue(testFile.exists(), "Testovací súbor by mal existovať");
    }


}