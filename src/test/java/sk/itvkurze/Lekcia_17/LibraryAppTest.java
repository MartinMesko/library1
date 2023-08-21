package sk.itvkurze.Lekcia_17;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LibraryAppTest {

    //Metóda má za úlohu overiť platnosť zadaného čísla titulu.
    //Číslo titulu musí byť platné v rámci dostupných titulov (knihy a DVD).
    @Test
    @DisplayName("Validate title number when input is invalid")
    public void whenInputIsValidThenReturnsNumber() {
        TitlesPage page = new TitlesPage();
        List<String> books = Arrays.asList("Book1", "Book2");
        List<String> dvds = Arrays.asList("DVD1");
        assertEquals(2, page.validateTitleNumber(2, books, dvds));
    }

    //Testuje, či metóda deleteBookTitle správne odstráni titul knihy zo zoznamu na základe zadaného čísla titulu.
    @Test
    public void whenDeleteMethodIsCorrectThenBookIsRemoved() {
        TitlesPage page = new TitlesPage();
        List<String> books = new ArrayList<>(Arrays.asList("Book1", "Book2"));
        List<String> updatedBooks = page.deleteBookTitle(1, books);
        assertFalse(updatedBooks.contains("Book1"));
    }
}
