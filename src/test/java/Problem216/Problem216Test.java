package Problem216;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem216Test {

    @Test
    void roundTest() {
        for (int i = Problem216.MIN_VALUE; i <= Problem216.MAX_VALUE; i++) {
            String romanNumeral = Problem216.convertDecimalIntegerToRomanNumeral(i);
            int valueBackToDecimal = Problem216.converRomanNumeralToDecimalInteger(romanNumeral);
            // System.out.format("%d -> %s -> %d\n", i, romanNumeral, valueBackToDecimal);

            assertEquals(i, valueBackToDecimal);

        }
    }

}
