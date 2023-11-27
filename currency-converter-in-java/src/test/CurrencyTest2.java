package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CurrencyTest2 {
    
    @Test // instructions
    public void testNormalConversion() {
        double convertedAmount = Currency.convert(100.0, 1.2);
        assertEquals(120.0, convertedAmount);
    }

    @Test // arcs
    public void testNegativeAmount() {
        double convertedAmount = Currency.convert(-100.0, 1.2);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // chemins
    public void testZeroExchangeRate() {
        double convertedAmount = Currency.convert(100.0, 0.0);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // conditions
    public void testNegativeExchangeRate() {
        double convertedAmount = Currency.convert(100.0, -1.2);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // i-chemins
    public void testZeroAmountNegativeExchangeRate() {
        double convertedAmount = Currency.convert(0.0, -1.2);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // conditions
    public void testValidAmountWithInvalidExchangeRate() {
        double convertedAmount = Currency.convert(100.0, -0.5);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // i-chemins
    public void testZeroAmountAndZeroExchangeRate() {
        double convertedAmount = Currency.convert(0.0, 0.0);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // conditions
    public void testAmountAtLowerLimit() {
        double convertedAmount = Currency.convert(0.0, 1.2);
        assertEquals(0.0, convertedAmount);
    }
}
