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

    @Test
    public void testConvertRounding() {
        BigDecimal conversionRate = BigDecimal.valueOf(0.055);
        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
        BigDecimal expectedResult = BigDecimal.valueOf(5.50).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsValid() {
        BigDecimal conversionRate = BigDecimal.valueOf(2.70);
        assertTrue(converter.isValid(conversionRate));
    }
    
    @Test
    public void testIsValidPositive() {
    	// should not work --> it fails because it is too large
    	BigDecimal conversionRate = BigDecimal.valueOf(100001);
    	assertTrue(converter.isValid(conversionRate));
    }
    
    @Test
    public void testIsValidNegative() {
    	//should fail because value of conversionRate is negative
    	BigDecimal conversionRate = BigDecimal.valueOf(-100);
    	assertTrue(converter.isValid(conversionRate));
    }
    
    @Test
    public void testIsValidnegativeResult() {
    	// should fail because conversion rate is negative
    	BigDecimal conversionRate = BigDecimal.valueOf(-2.70);
        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
        BigDecimal expectedResult = BigDecimal.valueOf(-269.97).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertTrue(converter.isValid(conversionRate));
        assertEquals(expectedResult, actualResult); 
    }
    
    @Test
    public void testIsValid100000() {
    	//should pass
    	BigDecimal conversionRate = BigDecimal.valueOf(100000);
    	assertTrue(converter.isValid(conversionRate));
    }
    
    @Test
    public void testIsValid0() {
    	//should fail
    	BigDecimal conversionRate = BigDecimal.valueOf(0.00);
    	assertTrue(converter.isValid(conversionRate));

    }
    
    @Test
    public void testConvertWrongEquals() {
    	//should fail
    	BigDecimal conversionRate = BigDecimal.valueOf(2.70);
        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
        BigDecimal expectedResult = BigDecimal.valueOf(269.96).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertTrue(converter.isValid(conversionRate));
        assertEquals(expectedResult, actualResult); 
    	
    }
    @Test
    public void testIsValidLarge() {
    	// should pass
    	BigDecimal conversionRate = BigDecimal.valueOf(99999);
        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
        BigDecimal expectedResult = BigDecimal.valueOf(9998900.01).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertTrue(converter.isValid(conversionRate));
        assertEquals(expectedResult, actualResult); 
    }
    @Test
    public void testIsValidTooLarge() {
    	// should fail because conversion rate is larger than 100000
    	BigDecimal conversionRate = BigDecimal.valueOf(100000.01);
        BigDecimal inputAmount = BigDecimal.valueOf(99.99);
        BigDecimal expectedResult = BigDecimal.valueOf(9999001.00).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertTrue(converter.isValid(conversionRate));
        assertEquals(expectedResult, actualResult); 
    }
    @Test
    public void testConvertRoundingBig() {
        BigDecimal conversionRate = BigDecimal.valueOf(0.055);
        BigDecimal inputAmount = BigDecimal.valueOf(99999.99);
        BigDecimal expectedResult = BigDecimal.valueOf(5500.00).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testConvertRoundingThousandths() {
    	//fails because conert() only rounds the first 3 decimal places to 2
        BigDecimal conversionRate = BigDecimal.valueOf(0.49585284);
        BigDecimal inputAmount = BigDecimal.valueOf(11092.01);
        BigDecimal expectedResult = BigDecimal.valueOf(5500.01).setScale(CurrencyConverter.DECIMAL_DIGITS);
        BigDecimal actualResult = converter.convert(inputAmount, conversionRate);
        assertEquals(expectedResult, actualResult);
    }
}