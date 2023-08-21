package sk.itvkurze.lekcia_14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LibraryAppHelper {
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public String lineSeparator = System.getProperty("line.separator");

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    //MM Obnovenie pôvodného výstupného prúdu po každom teste
    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    //MM Pomocná metóda pre poskytovanie vstupných dát jednotlivým testom
    public void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }
}
