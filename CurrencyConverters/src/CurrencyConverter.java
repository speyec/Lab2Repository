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

}