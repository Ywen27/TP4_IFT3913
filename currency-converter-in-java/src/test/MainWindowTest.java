package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


public class MainWindowTest {
    private ArrayList<Currency> currencies = Currency.init();

    // Test de conversion valide entre USD et EUR
    @Test
    public void testValidUSDtoEURConversion() {
        double amount = 500.0; // Montant valide
        double convertedAmount = MainWindow.convert("USD", "EUR", currencies, amount);
        assertTrue(convertedAmount > 0);
    }

    // Test pour un montant en dehors de la plage valide
    @Test
    public void testAmountOutOfRange() {
        double amount = 1000001.0; // Montant supérieur à la limite
        double convertedAmount = MainWindow.convert("USD", "EUR", currencies, amount);
        assertEquals(0, convertedAmount); // Hypothèse : le montant converti est 0 pour les entrées non valides
    }

    @Test
    public void testInvalidAmount() {
        ArrayList<Currency> currencies = Currency.init();
        double amount = -100.0; // Montant invalide
        double convertedAmount = MainWindow.convert("USD", "EUR", currencies, amount);

        // Assert que le montant converti est 0 ou une valeur d'erreur
        assertEquals(0, convertedAmount);
    }

}
