package sk.itvkurze.lekcia_14;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: musíme vymyslieť ešte názvy jednotlivých testov pre anotáciu @DisplayName

class LibraryApp2Test extends LibraryAppHelper{

    //MM Testovanie, či je správna chybová správa zobrazená pre nečíselné neplatné vstupy
    @Test
    void whenInputIsNotCorrect2ThenOutputShowsMessageTest() {
        provideInput("a" + lineSeparator + "5" + lineSeparator);
        LibraryApp.main(new String[]{});
        assertTrue(outContent.toString().contains("Please enter a valid value."));
    }

    //MM Pomocná metóda pre poskytovanie vstupných dát jednotlivým testom
    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

}
