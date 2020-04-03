import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {

    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        var numbersToSplit = numbers;
        String delimiters = "[";
        if (numbers.length() > 2) {
            if (numbers.substring(0, 2).equals("//")) {
                var splitOnNewLineDelimiter = numbers.split("\n", 2);
                var customDelimiter = splitOnNewLineDelimiter[0].replace("//", "");
                delimiters += customDelimiter + ",";
                numbersToSplit = splitOnNewLineDelimiter[1];
            }
        }
        delimiters = delimiters + ",\\n]+";

        var splitNumbers = numbersToSplit.split(delimiters);

        if (splitNumbers[0].length() == 0) {
            return 0;
        }

        int[] intArray = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt).toArray();

        String negativeValues = "";
        for (Integer value: intArray) {
            if (value < 0) {
                negativeValues += value.toString() + ",";
            }
        }

        if (!negativeValues.equals("")) {
            try {
                var messageString = "Negatives not allowed: " + negativeValues.substring(0, negativeValues.length() - 1);
                System.out.print(messageString);
                throw new Exception(messageString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            int sum = IntStream.of(intArray).sum();
            return sum;
    }

}
