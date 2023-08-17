package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryAppTest extends LibraryAppLection16Helper{

    /*
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
     */

    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderLybraryApp.class)
    public void whenSaveTheTitlesThanWriteTheText(Object object, boolean expected){
        boolean actual = TitlesPage.saveTitle(object);
        assertEquals(expected, actual);
    }
}
