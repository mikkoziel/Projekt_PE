public class BinaryCounter {

    public String numberOfOnesIn(String values) {
        var retrunString = "";
        var splitValues = values.split("[;, \\s]+");
        for (String splitValue: splitValues) {
            String valueForOperation = splitValue;
            if (splitValue.substring(0,1).equals("$")) {
                 var hexIntValue = Integer.parseInt(splitValue.substring(1, splitValue.length()), 16);
                 valueForOperation = String.valueOf(hexIntValue);
            }
            var integerValue = tryParse(valueForOperation);
            if (integerValue == null) {
                try {
                    var messageString = "blad";
                    System.out.print(messageString);
                    throw new Exception(messageString);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                return "blad";
            }
            if (integerValue > 255 | integerValue < 0) {
                try {
                    var messageString = "blad";
                    System.out.print(messageString);
                    throw new Exception(messageString);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                return "blad";
            }
            String binary = Integer.toBinaryString(integerValue);
            int numberOfOnes = (int) binary.chars().filter(ch -> ch == '1').count();
            retrunString += Integer.toString(numberOfOnes) + ",";
        }

        return retrunString.substring(0, retrunString.length() - 1);
    }

    public Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
