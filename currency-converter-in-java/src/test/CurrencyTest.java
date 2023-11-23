package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyTest {
    @Test
    public void testValidAmountConversion() {
        double amount = 50000.0; // Montant valide
        double exchangeRate = 0.8; // Taux de change hypothétique
        double convertedAmount = Currency.convert(amount, exchangeRate);
        assertEquals(40000.0, convertedAmount);
    }

    @Test
    public void testZeroAmount() {
        double amount = 0; // Montant à la limite inférieure
        double exchangeRate = 0.8;
        double convertedAmount = Currency.convert(amount, exchangeRate);
        assertEquals(0, convertedAmount);
    }

    @Test
    public void testUpperBoundaryAmount() {
        double amount = 1000000.0; // Montant à la limite supérieure
        double exchangeRate = 0.8;
        double convertedAmount = Currency.convert(amount, exchangeRate);
        assertEquals(800000.0, convertedAmount);
    }

    // Hypothèse : le montant converti est -1 pour les entrées non valides
    @Test
    public void testNegativeAmount() {
        double amount = -100.0; // Montant négatif
        double exchangeRate = 0.8;
        double convertedAmount = Currency.convert(amount, exchangeRate);
        assertEquals(-1, convertedAmount);
    }

    @Test
    public void testAmountOutOfRange() {
        double amount = 1000001.0; // Montant supérieur à la limite
        double exchangeRate = 0.8;
        double convertedAmount = Currency.convert(amount, exchangeRate);
        assertEquals(-1, convertedAmount);
    }

    @Test
    public void testInvalidCurrencyExchange() {
        double amount = 100.0;
        double exchangeRate = -0.5; // Taux de change invalide
        double convertedAmount = Currency.convert(amount, exchangeRate);
        assertEquals(-1, convertedAmount);
    }


}
