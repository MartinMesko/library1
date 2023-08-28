package sk.itvkurze.Lekcia_19;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProviderRemoveMember implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                arguments(new Member(
                        "Fero", "Skovajsa", "01.01.2000", 9998), true),
                arguments(new Member(
                        "Juraj", "Jánošík", "02.02.2002", 9999), false)
        );
    }
}
