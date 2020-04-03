import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Assert;

import java.util.stream.Stream;

public class NumberOfBitsTests {

    private static Stream<Arguments> upToTwoNumbers() {
        return Stream.of(
                Arguments.of("7", "3"),
                Arguments.of("0", "0"),
                Arguments.of("255", "8")
        );
    }

    @ParameterizedTest
    @MethodSource("upToTwoNumbers")
    void Count_CountTheOnes_OnlyOneNumber(String input, String expected) {

        var sut = new BinaryCounter();

        var result = sut.numberOfOnesIn(input);

        Assert.assertTrue(expected.equals(result));
    }

    private static Stream<Arguments> exceptionNegatives() {
        return Stream.of(
                Arguments.of("-2", "blad"),
                Arguments.of("260", "blad")
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionNegatives")
    void Count_ShouldThrowException_NumberOutOfBounds(String input, String expected) {

        var sut = new BinaryCounter();

        try {
            var result = sut.numberOfOnesIn(input);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals(expected));
        }
    }

    private static Stream<Arguments> multipleValues() {
        return Stream.of(
                Arguments.of("7;0", "3,0"),
                Arguments.of("0;255", "0,8"),
                Arguments.of("255;7", "8,3")
        );
    }

    @ParameterizedTest
    @MethodSource("multipleValues")
    void Count_CountTheOnes_ManyNumbers(String input, String expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertTrue(expected.equals(result));
    }

    private static Stream<Arguments> differenSeparators() {
        return Stream.of(
                Arguments.of("7;0", "3,0"),
                Arguments.of("0 255", "0,8"),
                Arguments.of("255;7 3", "8,3,2")
        );
    }

    @ParameterizedTest
    @MethodSource("differenSeparators")
    void Count_CountTheOnes_ManyNumbersWithDifferenSeparators(String input, String expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertTrue(expected.equals(result));
    }

    private static Stream<Arguments> anyWhiteSeparators() {
        return Stream.of(
                Arguments.of("7 0", "3,0"),
                Arguments.of("0\n255", "0,8"),
                Arguments.of("255   7 3", "8,3,2")
        );
    }

    @ParameterizedTest
    @MethodSource("anyWhiteSeparators")
    void Count_CountTheOnes_ManyNumbersWithAnyWhiteSeparators(String input, String expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertTrue(expected.equals(result));
    }

    private static Stream<Arguments> wrongSeparators() {
        return Stream.of(
                Arguments.of("7s0", "blad"),
                Arguments.of("0-255", "blad"),
                Arguments.of("255^7x3", "blad")
        );
    }

    @ParameterizedTest
    @MethodSource("wrongSeparators")
    void Count_CountTheOnes_ManyNumbersWithWrongSeparators(String input, String expected) {
        var sut = new BinaryCounter();

        try {
            var result = sut.numberOfOnesIn(input);
        } catch (Exception e) {
            Assert.assertTrue(e.getMessage().equals(expected));
        }
    }

    private static Stream<Arguments> hexValues() {
        return Stream.of(
                Arguments.of("7,$a4, $ff, 253", "3,3,8,7"),
                Arguments.of("0\n$a4", "0,3")
        );
    }

    @ParameterizedTest
    @MethodSource("hexValues")
    void Count_CountTheOnes_HexNumbers(String input, String expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertTrue(expected.equals(result));
    }
}
