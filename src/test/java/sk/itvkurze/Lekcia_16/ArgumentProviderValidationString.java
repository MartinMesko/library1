package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProviderValidationString implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        String expected = "titles";

        return Stream.of(
                arguments("titles", expected),
                arguments("666\ntitles\n", expected)
        );
    }
}
