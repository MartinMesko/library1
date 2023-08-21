package sk.itvkurze.Lekcia_16;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class testingValidationHelper {
    private static void simulateInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    static String getString(String input) {
        simulateInput(input);
        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckString();
    }

    static int getInt(String input) {
        simulateInput(input);
        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckInt();
    }

    static String getISBN(String input) {
        simulateInput(input);
        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckISBN();
    }
}
