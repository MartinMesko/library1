package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryAppArguTest extends testingValidationHelper{

    private TitlesPage titlesPage;

    @BeforeEach
    public void setUp() {
        titlesPage = new TitlesPage();
    }

    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderSaveTitle.class)
    public void testSaveDVDSuccessfully(Object object, boolean expected){
        boolean actual = titlesPage.saveTitle(object);
        assertEquals(expected, actual);
    }

    // testy true / false na validationCheckString()
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderValidationString.class)
    public void testingValidationString(String input, String expected){
        String actual = getString(input);
        assertEquals(expected, actual);
    }

    // testy true / false na validationCheckInt()
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderValidationInt.class)
    public void testingValidationInt(String input, int expected){
        int actual = getInt(input);
        assertEquals(expected, actual);
    }

    // testy true / false na validationCheckISBN()
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderValidationISBN.class)
    public void testingValidationISBN(String input, String expected){
        String actual = getISBN(input);
        assertEquals(expected, actual);
    }
}
