package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProviderValidationISBN implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                arguments("titles\n1234567891234\n", "1234567891234"),
                arguments("1234567891234\n", "1234567891234")
        );
    }
}
