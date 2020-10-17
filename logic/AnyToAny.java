package logic;

public class AnyToAny {
    public static String convertAnyToAny(String number, int destRadix, int sourceRadix) {
        return Integer.toString(Integer.parseInt(number, sourceRadix), destRadix);
    }
}
