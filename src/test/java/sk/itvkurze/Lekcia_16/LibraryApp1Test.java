package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryApp1Test {

    private TitlesPage titlesPage;

    // pred kazdym testom vytvara novy objekt triedy titlesPage
    @BeforeEach
    public void setUp() {
        titlesPage = new TitlesPage(null);
    }

    // uklada argument (objekt) pomocou testovanej tiredy a vysledok porovna s ocakavanou hodnotou
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderSaveTitle.class)
    public void testSaveSuccessfully(Object object, boolean expected){
        boolean actual = titlesPage.saveTitle(object);
        assertEquals(expected, actual);
    }

    // testy true / false na validationCheckString()
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderValidationString.class)
    public void testingValidationString(String input, String expected){
        TitlesPage titlesPage = new TitlesPage(new Scanner(input));
        String actual = titlesPage.validationCheckString();
        assertEquals(expected, actual);
    }

    // testy true / false na validationCheckInt()
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderValidationInt.class)
    public void testingValidationInt(String input, int expected){
        TitlesPage titlesPage = new TitlesPage(new Scanner(input));
        int actual = titlesPage.validationCheckInt();
        assertEquals(expected, actual);
    }

    // testy true / false na validationCheckISBN()
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderValidationISBN.class)
    public void testingValidationISBN(String input, String expected){
        TitlesPage titlesPage = new TitlesPage(new Scanner(input));
        String actual = titlesPage.validationCheckISBN();
        assertEquals(expected, actual);
    }
}
