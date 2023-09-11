package sk.itvkurze.Lekcia_20;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryAppTest {

    @Test
    void whenValidInputIsGivenThenReturnCorrectChoice() {
        setInput("1\n");
        int choice = LibraryApp.getValidatedChoice(7);
        assertEquals(1, choice);

    }



    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}