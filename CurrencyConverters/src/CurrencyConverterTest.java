import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {

    private CurrencyConverter converter;

    @BeforeEach
    public void setUp() {
        this.converter = new CurrencyConverter();
    }

    @Test
    public void testConvert() {
        BigDecimal conversionRate = BigDecimal.valueOf(2.70);
        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
        BigDecimal expectedResult = BigDecimal.valueOf(269.97).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertEquals(expectedResult, actualResult); // order is by convention
    }

//    @Test
//    public void testConvertRounding() {
//        BigDecimal conversionRate = BigDecimal.valueOf(0.055);
//        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
//        BigDecimal expectedResult = BigDecimal.valueOf(5.50).setScale(CurrencyConverter.DECIMAL_DIGITS);
//        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    public void testIsValid() {
//        BigDecimal conversionRate = BigDecimal.valueOf(2.70);
//        assertTrue(converter.isValid(conversionRate));
//    }

}