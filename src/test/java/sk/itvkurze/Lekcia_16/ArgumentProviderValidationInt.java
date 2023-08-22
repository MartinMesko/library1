package sk.itvkurze.Lekcia_16;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProviderValidationInt implements ArgumentsProvider {

    // vytvara objekty ako argumenty do testovacej metody
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        int espected = 666;

        return Stream.of(
                arguments("666\n", espected),
                arguments("titles\n666\n", espected)
        );
    }
}
