package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProviderSaveTitle implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                arguments(new DVD("E.T.", "Spielberg",7,99,0), true),
                arguments(new Book("Maria Antoneta", "Jakub Pele","1234567890123",234,10), true)
        );
    }
}
