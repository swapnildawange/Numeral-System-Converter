package tools;

import java.io.IOException;

public class Tool {
    // check if number is fraction and contains alphabets and digits
    public static boolean checkNumber(String number) {
        return (number.matches(("([a-z]+|\\d+)\\.([a-z0-9]+|\\d+)")));
    }

    // check if number is a integer i.e not include '.'
    public static boolean checkInteger(String number) {
        return (number.matches("[0-9a-z]+"));
    }

    public static String[] splitFraction(String number) {
        int decLoc = number.indexOf(".");
        String[] numArray = new String[2];
        numArray[0] = String.valueOf(Integer.parseInt(number.substring(0, decLoc)));
        // keep the .
        numArray[1] = String.valueOf(Double.parseDouble(number.substring(decLoc)));
        return numArray;

    }

    public static String[] splitFractionWithAlphabet(String number) {
        int decLoc = number.indexOf(".");
        String[] numArray = new String[2];
        numArray[0] = String.valueOf((number.substring(0, decLoc)));
        // remove the .
        numArray[1] = String.valueOf((number.substring(decLoc + 1)));
        return numArray;

    }

    // for decimal integer to any
    public static String integerConverter(String integerPart, int destRadix) {
        return Integer.toString(Integer.parseInt(integerPart), destRadix);

    }

    // convert any other base number into decimal fractional
    public static double fractionalConverter(String fractionalPart, int sourceRadix) {
        char[] fractionalDigits = fractionalPart.toCharArray();

        double ans = 0;
        int j = 1;

        for (char i : fractionalDigits) {

            double power = Math.pow(sourceRadix, j++);
          

            ans += (Character.getNumericValue(i) / power);

        }
        return ans;
       
    }

    // convert a decimal fractional number into any other base

    public static String decimalFractionalConverter(String fractionalPart, int destRadix) {

       
        StringBuilder converted = new StringBuilder();
        int j = 0;

        while (j < 5) {
           
            double f = Double.parseDouble(fractionalPart);
            double splitThisDouble = f * destRadix;
            String[] num = splitFraction(String.valueOf(splitThisDouble));
            converted.append(Integer.toString(Integer.parseInt(num[0]), destRadix));
            fractionalPart = num[1];
       
            j++;
        }
       
        return converted.toString();

    }
}
