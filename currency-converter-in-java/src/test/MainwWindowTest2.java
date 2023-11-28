package test;

import currencyConverter.MainWindow;
import currencyConverter.Currency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class MainwWindowTest2 {
    private ArrayList<Currency> currencies = Currency.init();

    @Test // instruction
    public void testNormalConversion() {
        double convertedAmount = MainWindow.convert("US Dollar", "Euro", currencies, 100.0);
        assertTrue(convertedAmount > 0);
    }

    @Test // arcs
    public void testUnsupportedCurrencyConversion() {
        double convertedAmount = MainWindow.convert("XXX", "YYY", currencies, 100.0);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // chemins
    public void testNegativeAmountConversion() {
        double convertedAmount = MainWindow.convert("US Dollar", "Euro", currencies, -100.0);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // conditions
    public void testZeroAmountConversion() {
        double convertedAmount = MainWindow.convert("US Dollar", "Euro", currencies, 0.0);
        assertTrue(convertedAmount >= 0);
    }

    @Test // i-chemins
    public void testAmountAboveLimitConversion() {
        double convertedAmount = MainWindow.convert("US Dollar", "Euro", currencies, 1000001.0);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // i-chemins
    public void testUnsupportedCurrenciesAndInvalidAmount() {
        double convertedAmount = MainWindow.convert("XXX", "YYY", currencies, -1.0);
        assertEquals(-1.0, convertedAmount);
    }

    @Test // conditions
    public void testAmountAtUpperLimit() {
        double convertedAmount = MainWindow.convert("US Dollar", "Euro", currencies, 1000000.0);
        assertTrue(convertedAmount >= 0);
    }
}
