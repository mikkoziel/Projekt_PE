import java.util.stream.Stream;

public class BinaryCounter {
    int numberOfOnesIn(String numbers) {
        if (numbers.isEmpty()) return 0;
        return Stream.of(normalize(numbers).split(";"))
                .mapToInt(this::countSetBitsInNumber)
                .sum();
    }

    private String normalize(String numbers) {
        return numbers.replaceAll("\\s+", ";");
    }

    private int countSetBitsInNumber(String number) {
        int intNumber = normalizeNumber(number);
        if (intNumber < 0 || intNumber > 255) {
            throw new IllegalArgumentException();
        }

        var count = Integer.toBinaryString(intNumber)
                .chars()
                .filter(i -> i == '1')
                .count();
        return (int) count;
    }

    private int normalizeNumber(String number) {
        return (number.startsWith("$")) ?
                Integer.parseInt(number.substring(1), 16)
                : Integer.parseInt(number);
    }
}
