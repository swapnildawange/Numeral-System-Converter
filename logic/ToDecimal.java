package logic;

import tools.Tool;

public class ToDecimal {
    public static void convertBaseToDecimal(String number, int destRadix,int sourceRadix) {
        String[] numArray = Tool.splitFractionWithAlphabet(number);
        String integerPart = numArray[0];
        String fractionalPart = numArray[1];
        StringBuilder finalConverted = new StringBuilder();

        // convert integerPart to deciaml
        
        String convertedIntegerPart = AnyToAny.convertAnyToAny(integerPart, destRadix, sourceRadix);
        finalConverted.append(convertedIntegerPart);
        // convert fractionalPart to deciaml
        double fractionalPartToDecimal = Tool.fractionalConverter(fractionalPart, sourceRadix);
        String convertedFraction = Tool.decimalFractionalConverter(String.valueOf(fractionalPartToDecimal),destRadix);
        finalConverted.append('.');
        finalConverted.append(convertedFraction);
        System.out.println(finalConverted);
    }

}
