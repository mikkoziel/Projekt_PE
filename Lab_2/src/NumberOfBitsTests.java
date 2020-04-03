import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.stream.Stream;


public class NumberOfBitsTests {

    private static Stream<Arguments> upToTwoNumbers() {
        return Stream.of(
                Arguments.of("7", 3),
                Arguments.of("0", 0),
                Arguments.of("255", 8)
        );
    }

    @ParameterizedTest
    @MethodSource("upToTwoNumbers")
    void count_CountSetBits_OnlyOneNumber(String input, int expected) {

        var sut = new BinaryCounter();

        var result = sut.numberOfOnesIn(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> exceptionNegatives() {
        return Stream.of(
                Arguments.of("-1"),
                Arguments.of("256"),
                Arguments.of("600")
        );
    }

    @ParameterizedTest
    @MethodSource("exceptionNegatives")
    void count_ShouldThrowException_NumberOutOfBounds(String input) {

        var sut = new BinaryCounter();

        assertThrows(IllegalArgumentException.class, ()-> sut.numberOfOnesIn(input));
    }

    private static Stream<Arguments> multipleValues() {
        return Stream.of(
                Arguments.of("7;0", 3),
                Arguments.of("0;255", 8),
                Arguments.of("255;7", 11)
        );
    }

    @ParameterizedTest
    @MethodSource("multipleValues")
    void count_CountSetBits_ManyNumbers(String input, int expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> differenSeparators() {
        return Stream.of(
                Arguments.of("7;0", 3),
                Arguments.of("0 255", 8),
                Arguments.of("255;7 3", 13)
        );
    }

    @ParameterizedTest
    @MethodSource("differenSeparators")
    void count_CountSetBits_ManyNumbersWithDifferenSeparators(String input, int expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> anyWhiteSeparators() {
        return Stream.of(
                Arguments.of("7 0", 3),
                Arguments.of("0\n255", 8),
                Arguments.of("255   7 3", 13)
        );
    }

    @ParameterizedTest
    @MethodSource("anyWhiteSeparators")
    void count_CountSetBits_ManyNumbersWithAnyWhiteSeparators(String input, int expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertEquals(expected, result);
    }

    private static Stream<Arguments> wrongSeparators() {
        return Stream.of(
                Arguments.of("7s0"),
                Arguments.of("0-255"),
                Arguments.of("255^7x3")
        );
    }

    @ParameterizedTest
    @MethodSource("wrongSeparators")
    void count_CountSetBits_ManyNumbersWithWrongSeparators(String input) {
        var sut = new BinaryCounter();

            assertThrows(IllegalArgumentException.class, ()-> sut.numberOfOnesIn(input));
    }

    private static Stream<Arguments> hexValues() {
        return Stream.of(
                Arguments.of("7;$a4;$ff;253", 21),
                Arguments.of("0\n$a4", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("hexValues")
    void count_CountSetBits_HexNumbers(String input, int expected) {

        var sut = new BinaryCounter();
        var result = sut.numberOfOnesIn(input);

        Assert.assertEquals(expected, result);
    }
}
