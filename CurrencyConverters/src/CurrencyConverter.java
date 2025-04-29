import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {

	public static final int DECIMAL_DIGITS = 2;

	public static void main(String[] args) {
        System.out.println("Hello CC");
    }

    public BigDecimal convert(BigDecimal inputAmount, BigDecimal conversionRate) {
        // TODO Auto-generated method stub
        return inputAmount.multiply(conversionRate).setScale(2, RoundingMode.HALF_UP);
    }
    public boolean isValid(BigDecimal conversionRate) {
        // TODO Auto-generated method stub
    	//modify this
        return  conversionRate.compareTo(BigDecimal.ZERO) > 0 
                && conversionRate.compareTo(new BigDecimal("100000")) <= 0
                && conversionRate != null;
    }

}