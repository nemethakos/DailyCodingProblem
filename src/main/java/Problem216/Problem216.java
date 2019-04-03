package Problem216;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a roman numeral String to decimal integer and vice versa
 */
public class Problem216 {

    /**
     * Minimum value of integer to convert to roman numeral String
     */
    public static final int MIN_VALUE = 0;
    
    /**
     * Maximum value of integer to convert to roman numeral String (can be changed to be higher)
     */
    public static final int MAX_VALUE = 100_000;
    
    private final static int ONE = 0;
    private final static int FIVE = 1;
    private final static int TEN = 2;

    // first index decimal places (0= ones, 1 = tens, 2 = hundreds, 3=thousands
    // second index 0=1, 1=5, 2=10
    private final static char[][] DECIMAL_TO_ROMAN_DIGIT = {
            // group for ones (1, 5, 10)
            { 'I', 'V', 'X' },
            // group for tens (10, 50, 100)
            { 'X', 'L', 'C' },
            // group for hundredths (100, 500, 1000)
            { 'C', 'D', 'M' },
            // group for thousands (1000)
            { 'M' } };

    private static Map<Character, Integer> romanNumeralValues = new HashMap<>();

    static {
        romanNumeralValues.put('M', 1000);
        romanNumeralValues.put('D', 500);
        romanNumeralValues.put('C', 100);
        romanNumeralValues.put('L', 50);
        romanNumeralValues.put('X', 10);
        romanNumeralValues.put('V', 5);
        romanNumeralValues.put('I', 1);
    }

    private static int getRomanNumeralValue(char c) {
        if (!romanNumeralValues.containsKey(c)) {
            throw new IllegalArgumentException(String.format("'%c' is not a roman numeral!", c));
        }
        return romanNumeralValues.get(c);
    }

    /**
     * Converts the roman numberal to decimal integer
     * 
     * @param romanNumeralText the roman numeral String with substractive notation
     * @return the decimal integer from roman numeral String
     */
    public static int converRomanNumeralToDecimalInteger(String romanNumeralText) {
        int numberValue = 0;
        int index = 0;
        while (index < romanNumeralText.length()) {
            int currentNumeralValue = getRomanNumeralValue(romanNumeralText.charAt(index));

            int nextNumeralValue = 0;
            // is there a next character & next value is greater than current value?
            if (index + 1 < romanNumeralText.length() && (nextNumeralValue = getRomanNumeralValue(
                    romanNumeralText.charAt(index + 1))) > currentNumeralValue) {
                numberValue += (nextNumeralValue - currentNumeralValue);
                index += 2;
                // no next char or the next char is greater than current char
            } else {
                numberValue += currentNumeralValue;
                index += 1;
            }
        }

        return numberValue;
    }

    /**
     * Converts one decimal digit with the given decimal places into roman numeral
     * representation
     * 
     * @param digit         the digit 0-9 for decimal places 0-2, or digit>0 for
     *                      decimal places == 3
     * @param decimalPlaces the decimal places after the digit, e.g.: 2 = 100
     * @return the roman number representation of the digit * 10 ^ decimalPlaces
     */
    private static String convertDigitToRoman(int digit, int decimalPlaces) {
        StringBuilder sb = new StringBuilder();

        char[] romanDigits = DECIMAL_TO_ROMAN_DIGIT[decimalPlaces];

        // thousands are treated specially, since the biggest number is 'M' = 1000, so
        // we need to repeat the M as many times, as the value of digit
        if (decimalPlaces == 3) {
            for (int i = 1; i <= digit; i++) {
                sb.append(romanDigits[ONE]);
            }
        } else {

            switch (digit) {
            case 0:
                return "";
            case 1:
            case 2:
            case 3:
                for (int i = 1; i <= digit; i++) {
                    sb.append(romanDigits[ONE]);
                }
                break;
            case 4:
                sb.append(romanDigits[ONE]);
                sb.append(romanDigits[FIVE]);
                break;
            case 5:
                sb.append(romanDigits[FIVE]);
                break;
            case 6:
            case 7:
            case 8:
                sb.append(romanDigits[FIVE]);
                for (int i = 6; i <= digit; i++) {
                    sb.append(romanDigits[ONE]);
                }
                break;
            case 9:
                sb.append(romanDigits[ONE]);
                sb.append(romanDigits[TEN]);
            }
        }
        return sb.toString();
    }

    /**
     * Converts decimal integer to roman numeral String
     * 
     * @param decimalValue the decimal value
     * @return the roman numeral String from the decimalValue
     */
    public static String convertDecimalIntegerToRomanNumeral(int decimalValue) {

        if (decimalValue < MIN_VALUE || decimalValue > MAX_VALUE) {
            throw new IllegalArgumentException(
                    String.format("%d is out of range [%d,%d]", decimalValue, MIN_VALUE, MAX_VALUE));
        }

        StringBuilder romanNumeral = new StringBuilder();

        int digit = 0;
        int decimalPlaces = 0;
        String romanStr = "";

        while (decimalPlaces <= 3) {
            if (decimalPlaces == 3) {
                digit = decimalValue;
            } else {
                digit = decimalValue % 10;
            }
            decimalValue /= 10;

            romanStr = convertDigitToRoman(digit, decimalPlaces);

            romanNumeral.insert(0, romanStr);

            decimalPlaces++;
        }

        return romanNumeral.toString();
    }

}
