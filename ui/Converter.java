package ui;

import logic.AnyToAny;
import logic.DecimalToAny;
import logic.ToDecimal;
import tools.Tool;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Converter {
    static Scanner scanner = new Scanner(System.in);

    public static void Run() {
        int sourceRadix = 0;
        String number = "";
        int destRadix = 0;
        boolean error = false;
        if (scanner.hasNext()) {
            try {
                sourceRadix = scanner.nextInt();
                if (sourceRadix <= 0 || sourceRadix > 36) {
                    error = true;
                }
            } catch (InputMismatchException e) {
                error = true;
            }

        } else {
            error = true;
        }
        if (scanner.hasNext()) {
            number = scanner.next();

        }
        if (scanner.hasNext()) {
            try {
                destRadix = scanner.nextInt();
                if (destRadix <= 0 || destRadix > 36) {
                    error = true;
                }
            } catch (InputMismatchException e) {
                error = true;
            }
        } else {
            error = true;
        }
        // if error
        if (error) {
            System.out.println("error");
        } else if (sourceRadix == 1) {
            int ans = 0;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == '1') {
                    ans += 1;
                }
            }
            // if srcRadix and destRadix both are 1
            if (destRadix == 1) {

                System.out.println(ans);
            }
            // if srcRadix is 1 but destRadix is different
            else {
                String num = Integer.toString(ans, destRadix);
                System.out.println(num);
            }

        }
        // if only destination radix is 1;
        else if (destRadix == 1) {
            StringBuilder ans = new StringBuilder();
            String num = AnyToAny.convertAnyToAny(number, 1, 6);
            for (int i = 0; i < Integer.parseInt(num); i++) {
                ans.append('1');
            }
            System.out.println(ans);

        } else {
            // if number is fraction
            if (!Tool.checkInteger(number)) {
                // number is fraction and contains alphabets and digits;
                if (Tool.checkNumber(number)) {

                    ToDecimal.convertBaseToDecimal(number, destRadix, sourceRadix);

                }
                // number is in fraction but does not contain any alphabets;
                else {

                    DecimalToAny.convertDecimalToAnyBase(number, destRadix, sourceRadix);

                }

            }
            // number is integer
            else {
                System.out.println(AnyToAny.convertAnyToAny(number, destRadix, sourceRadix));
            }
        }
    }

}
