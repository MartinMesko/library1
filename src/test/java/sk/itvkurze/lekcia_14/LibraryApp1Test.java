package sk.itvkurze.lekcia_14;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: musíme vymyslieť ešte názvy jednotlivých testov pre anotáciu @DisplayName

class LibraryApp1Test extends LibraryAppHelper{

    //MM Testovanie, či správna chybová správa je zobrazená pre neplatný číselný vstup
    @Test
    void whenInputIsNotCorrectThenOutputShowsMessageTest() {
        provideInput("6" + lineSeparator + "5" + lineSeparator);
        LibraryApp.main(new String[]{});
        assertTrue(outContent.toString().contains("Please enter a number in the range from 1 to 5"));
    }

    //MM Pomocná metóda pre poskytovanie vstupných dát jednotlivým testom
    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

}
