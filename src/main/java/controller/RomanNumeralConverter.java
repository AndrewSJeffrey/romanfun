package controller;

import generator.RomanNumeralGenerator;
import generator.impl.RomanNumeralGeneratorImpl;
import model.RomanNumeralResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller

@RequestMapping("/romanNumeralConverter")
public class RomanNumeralConverter {

    private RomanNumeralGenerator romanNumeralGenerator = new RomanNumeralGeneratorImpl();

    @ResponseBody
    @RequestMapping(value = "/fromInt", method = {RequestMethod.GET})
    public RomanNumeralResponse generateRomanNumeral(@RequestParam(value = "value") int value) {
        return new RomanNumeralResponse(value, romanNumeralGenerator.generate(value));
    }

    @ResponseBody
    @RequestMapping(value = "/fromNumeral", method = {RequestMethod.GET})
    public RomanNumeralResponse getIntFromNumeral(@RequestParam(value = "value") String value) {
        return new RomanNumeralResponse(romanNumeralGenerator.parse(value), value);
    }
}


