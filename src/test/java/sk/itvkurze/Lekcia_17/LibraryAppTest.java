package sk.itvkurze.Lekcia_17;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

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

    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderIncorectInput.class)
    void testValidationChecksTheRemovedNumberIsIncorect(String input, int expected, int rangeTo){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TitlesPage titlesPage = new TitlesPage();
        TitlesPage.totalTitlesCount = rangeTo;
        int actual = titlesPage.validationChecksTheRemovedNumber();
        assertEquals(expected, actual);
    }
}
