package ru.yandex.practicum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @DisplayName("при умножении стоимости акции в валюте на количество получаем величину в валюте")
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);

        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @DisplayName("При сравнении двух объектов получаем корректный результат")
    @Test
    public void testEquality() {

        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @DisplayName("тестирование идентификатора валюты")
    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @DisplayName("При сложении 5 и 5 долларов получаем 10")
    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Exspression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
}