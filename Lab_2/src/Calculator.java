import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Calculator {

    String delimiterRegex = "[,\n]";

    int add(String numbers) {
        if (numbers.equals("")) return 0;

        if (numbers.matches("//.\n.+")) {
            delimiterRegex = numbers.substring(2, 3);
            numbers = numbers.substring(4);
        }

        final String[] splitedNumbers = numbers.split(delimiterRegex);

        Supplier<Stream<Integer>> streamSupplier = () -> Arrays.stream(splitedNumbers).map(Integer::parseInt);

        Integer[] negativeIntegers = streamSupplier.get().filter(integer -> integer < 0).toArray(Integer[]::new);
        if (negativeIntegers.length > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + Arrays.toString(negativeIntegers));
        }

        return streamSupplier.get()
                .reduce(Integer::sum)
                .orElseThrow();
    }
}