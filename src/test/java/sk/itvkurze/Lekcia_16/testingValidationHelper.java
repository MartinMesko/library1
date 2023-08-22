package sk.itvkurze.Lekcia_16;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class testingValidationHelper {
    // pomocna metoda pre vytvaranie simulacie vstupu
    private static void simulateInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    // simuluje vstup od uzivatela
    static String getString(String input) {
        simulateInput(input);
        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckString();
    }

    // simuluje vstup od uzivatela
    static int getInt(String input) {
        simulateInput(input);
        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckInt();
    }

    // simuluje vstup od uzivatela
    static String getISBN(String input) {
        simulateInput(input);
        TitlesPage titlesPage = new TitlesPage();
        return titlesPage.validationCheckISBN();
    }
}
