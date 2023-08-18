package sk.itvkurze.Lekcia_17;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryAppTest {

    private TitlesPage titlesPage;

    @BeforeEach
    public void setUp() {
        titlesPage = new TitlesPage();
    }

    @Test
    public void testValidateTitleNumber_validInput_returnsNumber() {
        TitlesPage page = new TitlesPage();
        List<String> books = Arrays.asList("Book1", "Book2");
        List<String> dvds = Arrays.asList("DVD1");
        assertEquals(2, page.validateTitleNumber(2, books, dvds));
    }

    @Test
    public void testDeleteBookTitle_validInput_removesBook() {
        TitlesPage page = new TitlesPage();
        List<String> books = new ArrayList<>(Arrays.asList("Book1", "Book2"));
        List<String> updatedBooks = page.deleteBookTitle(1, books);
        assertFalse(updatedBooks.contains("Book1"));
    }
}
