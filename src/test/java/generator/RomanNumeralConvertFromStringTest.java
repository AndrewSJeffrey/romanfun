package generator;


import generator.impl.RomanNumeralGeneratorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by andrewjeffrey on 09/09/15.
 */
@RunWith(value = Parameterized.class)
public class RomanNumeralConvertFromStringTest {

    private int expectedIntegerValue;
    private String romanNumeral;

    private RomanNumeralGenerator romanNumeralGenerator = new RomanNumeralGeneratorImpl();


    @Parameterized.Parameters(name = "{index}: ({0})={1}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                //Special cases
                {1000, "M"},
                {900, "CM"},
                {500, "D"},
                {400, "CD"},
                {100, "C"},
                {90, "XC"},
                {50, "L"},
                {40, "XL"},
                {10, "X"},
                {9, "IX"},
                {5, "V"},
                {4, "IV"},
                {1, "I"},

                //Additional tests
                {2, "II"},
                {8, "VIII"},
                {16,"XVI"},
                {32,"XXXII"},
                {64,"LXIV"},
                {128,"CXXVIII"},
                {256,"CCLVI"},
                {512,"DXII"},
                {1024,"MXXIV"},
                {2056,"MMLVI"},

        });
    }

    public RomanNumeralConvertFromStringTest(int expectedIntegerValue, String romanNumeral) {
        this.expectedIntegerValue = expectedIntegerValue;
        this.romanNumeral = romanNumeral;
    }

    @Test
    public void testAccountSettingsUpdateNormalizer() {
        final int parsedValue = romanNumeralGenerator.parse(romanNumeral);
        assertReflectionEquals("Values should be the same", parsedValue, expectedIntegerValue);
    }
}
