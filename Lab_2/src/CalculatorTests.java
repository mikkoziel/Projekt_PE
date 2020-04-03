import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Assert;

import java.util.stream.Stream;

public class CalculatorTests {

    private static Stream<Arguments> upToTwoNumbers() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("upToTwoNumbers")
    void add_AddUpToTwoNumbers_WhenStringIsValid(String input, int expected) {

        var sut = new Calculator();

        var result = sut.add(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> upToAnyNumbers() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1,2", 3),
                Arguments.of("10,20,50", 80),
                Arguments.of("1,2,3,4", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("upToAnyNumbers")
    void add_AddUpToAnyNumbers_WhenStringIsValid(String input, int expected) {

        var sut = new Calculator();

        var result = sut.add(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> lineDelimiter() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1,2", 3),
                Arguments.of("10,20\n50", 80),
                Arguments.of("1,2\n3,4", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("lineDelimiter")
    void add_AddUpToAnyNumbers_WithLineDelimiter(String input, int expected) {

        var sut = new Calculator();

        var result = sut.add(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> lineCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2", 3),
                Arguments.of("//;\n3;4;5", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("lineCustomDelimiter")
    void add_AddUpToAnyNumbers_WithCustomLineDelimiter(String input, int expected) {

        var sut = new Calculator();

        var result = sut.add(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> exceptionNegatives() {
        return Stream.of(
                Arguments.of("1,-2,1", "[-2]"),
                Arguments.of("//;\n3;-4;-5", "[-4, -5]")
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionNegatives")
    void add_ShouldThrowException_WhenNegativesAreUsed(String input, String expected) {

        var sut = new Calculator();
        try {
            var result = sut.add(input);
        } catch (Exception e) {
            Assert.assertEquals("Negatives not allowed: " + expected, e.getMessage());
        }
    }
}