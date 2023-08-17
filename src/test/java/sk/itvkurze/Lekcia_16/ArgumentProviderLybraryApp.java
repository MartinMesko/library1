package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProviderLybraryApp implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                arguments(new Book(999,"NewTitle", "NewAuthor", "ISBN002", 150, 5), true),
                arguments(new DVD(999,"NewTitle", "NewAuthor", 8, 150, 5), true)
        );
    }
}
