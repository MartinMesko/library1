package sk.itvkurze.lekcia_14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class LibraryApp3Test extends LibraryAppHelper{

    //MM Testovanie, či výstup zobrazuje správny text pre platný vstup
    @Test
    void whenInputIsCorrectThenOutputShowsCorrectPageTest() {
        String input = "5" + lineSeparator;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        LibraryApp.main(new String[]{});

        String expectedOutput = "1 - Titles" + lineSeparator +
                "2 - Members" + lineSeparator +
                "3 - Rentals" + lineSeparator +
                "4 - Messages" + lineSeparator +
                "5 - Exit" + lineSeparator;
        Assertions.assertTrue(outContent.toString().contains(expectedOutput));
    }
}
