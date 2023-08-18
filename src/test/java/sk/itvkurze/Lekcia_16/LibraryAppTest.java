package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryAppTest {

    private TitlesPage titlesPage;

    @BeforeEach
    public void setUp() {
        titlesPage = new TitlesPage();
    }

    @Test
    public void testSaveBookSuccessfully() {
        Book newBook = new Book("NewTitle", "NewAuthor", "ISBN002", 150, 5);
        boolean result = titlesPage.saveTitle(newBook);
        assertTrue(result, "Ukladanie knihy malo prebehnúť úspešne");


    }

    @Test
    public void testSaveDVDSuccessfully() {
        DVD newDVD = new DVD("NewTitle", "NewAuthor", 7, 120, 3);
        boolean result = titlesPage.saveTitle(newDVD);
        assertTrue(result, "Ukladanie DVD malo prebehnúť úspešne");


    }

    // testy true / false na validationCheckString()
    @Test
    public void testingValidationStringTrue() {
        String input = "titles";
        String actual = getString(input);

        assertEquals("titles", actual);
    }
    @Test
    public void testingValidationStringFalse() {
        String input = "666\ntitles\n";
        String actual = getString(input);

        assertEquals("titles", actual);
    }

    private static String getString(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckString();
    }


    // testy true / false na validationCheckInt()
    @Test
    public void testingValidationIntTrue() {
        String input = "666\n";
        int actual = getInt(input);

        assertEquals(666, actual);
    }

    @Test
    public void testingValidationIntFalse() {
        String input = "titles\n666\n";
        int actual = getInt(input);

        assertEquals(666, actual);
    }

    private static int getInt(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckInt();
    }

    // testy true / false na validationCheckISBN()
    @Test
    public void testingValidationISBNTrue() {
        String input = "1234567891234\n";
        String actual = getISBN(input);

        assertEquals("1234567891234", actual);
    }

    @Test
    public void testingValidationISBNFalse() {
        String input = "titles\n1234567891234\n";
        String actual = getISBN(input);

        assertEquals("1234567891234", actual);
    }

    private static String getISBN(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckISBN();
    }
}
