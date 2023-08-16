package sk.itvkurze.lekcia_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sk.itvkurze.Lekcia_15.TitlesPage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TitlesPage1Test {
    @Test
    void ifTheQuotedLinesFromTheBookfileAreNotIdenticalThanPrintTheText() throws IOException {
        int actualAddedTitlesCount =  TitlesPage.loadTitlesFromFile("bookTest.txt", "Book");

        assertEquals(10, actualAddedTitlesCount);
    }

    @Test
    void ifTheQuotedLinesFromTheDVDfileAreNotIdenticalThanPrintTheText() throws IOException {
        int actualAddedTitlesCount =  TitlesPage.loadTitlesFromFile("DVDTest.txt", "DVD");

        assertEquals(10, actualAddedTitlesCount);
    }

    @BeforeEach
    void resetTheInstanceVariable(){
        TitlesPage.addedTitlesCount = 0;
    }
}