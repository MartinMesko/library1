package sk.itvkurze.Lekcia_15;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TitlesPage1Test {
    // posiela do metody loadTitlesFromFile() cestu k suboru a typ suboru a vysledok porovna s ocakavanou hodnotou
    @ParameterizedTest
    @CsvSource(value = {"bookTest.txt, Book, 10", "DVDTest.txt, DVD, 10"})
    void ifTheQuotedLinesFromTheFileAreNotIdenticalThanPrintTheText(String filePatch, String type, int expected) throws IOException {
        int actual =  TitlesPage.loadTitlesFromFile(filePatch, type);
        assertEquals(expected, actual);
    }
}