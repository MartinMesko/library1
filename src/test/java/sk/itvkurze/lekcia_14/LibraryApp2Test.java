package sk.itvkurze.lekcia_14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryApp2Test extends LibraryAppHelper{

    //MM Testovanie, či je správna chybová správa zobrazená pre nečíselné neplatné vstupy
    @Test
    void whenInputIsNotCorrect2ThenOutputShowsMessageTest() {
        provideInput("a" + lineSeparator + "5" + lineSeparator);
        LibraryApp.main(new String[]{});
        assertTrue(outContent.toString().contains("Please enter a valid value."));
    }
}
