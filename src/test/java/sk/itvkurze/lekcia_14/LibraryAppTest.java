package sk.itvkurze.lekcia_14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: musíme vymyslieť ešte názvy jednotlivých testov pre anotáciu @DisplayName


class LibraryAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    // pred kazdym testom nastavuje novy vystupmy prud
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    //MM Testovanie, či správna chybová správa je zobrazená pre neplatný číselný vstup
    @Test
    void whenInputIsNotCorrectThenOutputShowsMessageTest() {
        String lineSeparator = System.getProperty("line.separator");
        provideInput("6" + lineSeparator + "5" + lineSeparator);
        LibraryApp.main(new String[]{});
        assertTrue(outContent.toString().contains("Please enter a number in the range from 1 to 5"));
    }

    //MM Testovanie, či je správna chybová správa zobrazená pre nečíselné neplatné vstupy
    @Test

    void whenInputIsNotCorrect2ThenOutputShowsMessageTest() {
        String lineSeparator = System.getProperty("line.separator");
        provideInput("a" + lineSeparator + "5" + lineSeparator);
        LibraryApp.main(new String[]{});
        assertTrue(outContent.toString().contains("Please enter a valid value."));
    }

    //MM Testovanie, či výstup zobrazuje správny text pre platný vstup
    @Test
    void whenInputIsCorrectThenOutputShowsCorrectPageTest() {
        String lineSeparator = System.getProperty("line.separator");
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

    //MM Obnovenie pôvodného výstupného prúdu po každom teste
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    //MM Pomocná metóda pre poskytovanie vstupných dát jednotlivým testom
    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

}
