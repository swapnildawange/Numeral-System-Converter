package logic;

import tools.Tool;

public class DecimalToAny {
    public static void convertDecimalToAnyBase(String number, int destRadix, int sourceRadix) {
        String[] numArray = Tool.splitFraction(number);
        String integerPart = numArray[0];
        String fractionalPaart = numArray[1];

        // convert integerPart to deciaml
        String convertedIntegerPart = Tool.integerConverter(integerPart, destRadix);

        // convert fractionalPart to deciaml
        String convertedFraction = Tool.decimalFractionalConverter(fractionalPaart, destRadix);
        StringBuilder finalConverted = new StringBuilder();
        finalConverted.append(convertedIntegerPart).append('.').append(convertedFraction);
        System.out.println(finalConverted);
    }
}
