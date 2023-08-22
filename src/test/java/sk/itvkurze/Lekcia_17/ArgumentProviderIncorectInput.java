package sk.itvkurze.Lekcia_17;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProviderIncorectInput implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        int expected = 3;
        int rangeTo = 3;
        return Stream.of(
                arguments("3\n", expected, rangeTo),
                arguments("16\n3\n", expected, rangeTo),
                arguments("df\n3\n", expected, rangeTo)
        );
    }
}
