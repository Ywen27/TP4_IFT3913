package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class MainWindowTest {
    private ArrayList<Currency> currencies = Currency.init();

    @Test
    public void testValidConversion() {
        double amount = 100.0; // Montant de test
        String[] Currencies = {"USD", "EUR", "GBP", "CHF", "CNY", "JPY"};
        for (String fromCurrency : Currencies) {
            for (String toCurrency : Currencies) {
                double convertedAmount = MainWindow.convert(fromCurrency, toCurrency, currencies, amount);
                assertTrue(convertedAmount >= 0);
            }
        }
    }

    @Test
    public void testZeroAmount() {
        double amount = 0.0;
        double convertedAmount = MainWindow.convert("USD", "EUR", currencies, amount);
        assertEquals(0, convertedAmount);
    }

    @Test
    public void testUpperBoundaryAmount() {
        double amount = 1000000.0;
        double convertedAmount = MainWindow.convert("USD", "EUR", currencies, amount);
        assertTrue(convertedAmount >= 0);
    }

    // Hypothèse : le montant converti est -1 pour les entrées non valides
    @Test
    public void testAmountOutOfRange() {
        double amount = 1000001.0; // Montant supérieur à la limite
        double convertedAmount = MainWindow.convert("USD", "EUR", currencies, amount);
        assertEquals(-1, convertedAmount);
    }

    @Test
    public void testInvalidAmount() {
        double amount = -100.0; // Montant invalide
        double convertedAmount = MainWindow.convert("USD", "EUR", currencies, amount);
        assertEquals(-1, convertedAmount);
    }

    @Test
    public void testConversionWithUnsupportedCurrency() {
        double amount = 100.0;
        double convertedAmount = MainWindow.convert("USD", "XYZ", currencies, amount);
        assertEquals(-1, convertedAmount);
    }

}
