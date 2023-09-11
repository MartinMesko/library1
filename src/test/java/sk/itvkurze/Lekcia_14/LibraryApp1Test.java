package sk.itvkurze.Lekcia_14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryApp1Test extends LibraryAppHelper{

    //MM Testovanie, či správna chybová správa je zobrazená pre neplatný číselný vstup
    @Test
    void whenInputIsNotCorrectThenOutputShowsMessageTest() {
        provideInput("6" + lineSeparator + "5" + lineSeparator);
        LibraryApp.main(new String[]{});
        assertTrue(outContent.toString().contains("Please enter a number in the range from 1 to 5"));
    }
}
