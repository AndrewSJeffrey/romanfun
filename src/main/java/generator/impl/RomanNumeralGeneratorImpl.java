package generator.impl;

import generator.RomanNumeralGenerator;

import java.util.TreeMap;

/**
 * Created by andrewjeffrey on 09/09/15.
 */
public class RomanNumeralGeneratorImpl implements RomanNumeralGenerator {

    final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    @Override
    public String generate(int integerValue) {
        int l = map.floorKey(integerValue);
        if (integerValue == l) {
            return map.get(integerValue);
        }
        return map.get(l) + generate(integerValue - l);
    }

    @Override
    public int parse(String number) {
        if (number == null || number.length() == 0) return 0;
        if (number.startsWith("M")) return 1000 + parse(number.substring(1));
        if (number.startsWith("CM")) return 900 + parse(number.substring(2));
        if (number.startsWith("D")) return 500 + parse(number.substring(1));
        if (number.startsWith("CD")) return 400 + parse(number.substring(2));
        if (number.startsWith("C")) return 100 + parse(number.substring(1));
        if (number.startsWith("XC")) return 90 + parse(number.substring(2));
        if (number.startsWith("L")) return 50 + parse(number.substring(1));
        if (number.startsWith("XL")) return 40 + parse(number.substring(2));
        if (number.startsWith("X")) return 10 + parse(number.substring(1));
        if (number.startsWith("IX")) return 9 + parse(number.substring(2));
        if (number.startsWith("V")) return 5 + parse(number.substring(1));
        if (number.startsWith("IV")) return 4 + parse(number.substring(2));
        if (number.startsWith("I")) return 1 + parse(number.substring(1));
        throw new IllegalArgumentException("Value was not a numerical String");
    }
}
