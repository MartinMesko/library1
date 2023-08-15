package sk.itvkurze.lekcia_15;

import org.junit.jupiter.api.Test;
import sk.itvkurze.Lekcia_15.TitlesPage;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Lekcia15Test {
    @Test
    public void testLoadTitlesFromFileTest() throws IOException {
        List<String> titles =  TitlesPage.loadTitlesFromFile("test.txt");

        assertEquals("ABC", titles.get(0));
        assertEquals("DEF", titles.get(1));
        assertEquals("GHI", titles.get(2));
    }
}