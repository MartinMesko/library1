package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryAppTest {

    /*
    private TitlesPage titlesPage;

    // pred kazdym testom vytvara novy objekt triedy titlesPage
    @BeforeEach
    public void setUp() {
        titlesPage = new TitlesPage();
    }

    // uklada objekt triedy Book pomocou metody saveTitle() a vysledok porovna s ocakavanou hodnotou
    @Test
    public void testSaveBookSuccessfully() {
        Book newBook = new Book("NewTitle", "NewAuthor", "ISBN002", 150, 5);
        boolean result = titlesPage.saveTitle(newBook);
        assertTrue(result, "Ukladanie knihy malo prebehnúť úspešne");


    }

    // uklada objekt triedy DVD pomocou metody saveTitle() a vysledok porovna s ocakavanou hodnotou
    @Test
    public void testSaveDVDSuccessfully() {
        DVD newDVD = new DVD("NewTitle", "NewAuthor", 7, 120, 3);
        boolean result = titlesPage.saveTitle(newDVD);
        assertTrue(result, "Ukladanie DVD malo prebehnúť úspešne");


    }

    // test na validaciu retazca z vysledkom metody - true
    @Test
    public void testingValidationStringTrue() {
        String input = "titles";
        String actual = getString(input);

        assertEquals("titles", actual);
    }

    // test na validaciu retazca z vysledkom metody - false, potom true
    @Test
    public void testingValidationStringFalse() {
        String input = "666\ntitles\n";
        String actual = getString(input);

        assertEquals("titles", actual);
    }

    // pomocna metoda na simulaciu vstupu
    private static String getString(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckString();
    }


    // test na validaciu celeho cisla z vysledkom metody - true
    @Test
    public void testingValidationIntTrue() {
        String input = "666\n";
        int actual = getInt(input);

        assertEquals(666, actual);
    }

    // test na validaciu celeho cisla z vysledkom metody - false, potom true
    @Test
    public void testingValidationIntFalse() {
        String input = "titles\n666\n";
        int actual = getInt(input);

        assertEquals(666, actual);
    }

    // pomocna metoda na simulaciu vstupu
    private static int getInt(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckInt();
    }

    // test na validaciu retazca preparsuje vstup na long z vysledkom metody - true
    @Test
    public void testingValidationISBNTrue() {
        String input = "1234567891234\n";

        long actual = Long.parseLong(getISBN(input));
        long expected = Long.parseLong("1234567891234");

        assertEquals(expected, actual);
    }

    // test na validaciu retazca preparsuje vstup na long z vysledkom metody - false, potom true
    @Test
    public void testingValidationISBNFalse() {
        String input = "titles\n1234567891234\n";
        long actual = Long.parseLong(getISBN(input));
        long expected = Long.parseLong("1234567891234");

        assertEquals(expected, actual);
    }

    // pomocna metoda na simulaciu vstupu
    private static String getISBN(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckISBN();
    }
     */
}
