package model;

/**
 * Created by andrewjeffrey on 09/09/15.
 */
public class RomanNumeralResponse {

    private int value;
    private String numeral;


    public RomanNumeralResponse() {
    }

    public RomanNumeralResponse(int value, String numeral) {
        this.value = value;
        this.numeral = numeral;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getNumeral() {
        return numeral;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }
}
