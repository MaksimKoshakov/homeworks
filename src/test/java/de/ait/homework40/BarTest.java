package de.ait.homework40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    private Bar bar;

    @BeforeEach
    public void setUp (){
        bar = new Bar();
    }

    @Test
    void addDrinkSuccess() {
        Drink drink = new Drink("Bier", "alcohol", 500);
        Map<String, Drink>resultAllDrink = bar.getBarCollection();
        Assertions.assertEquals(0,resultAllDrink.size());
        Assertions.assertTrue(bar.addDrink("1",drink));
        resultAllDrink = bar.getBarCollection();
        Assertions.assertEquals(1,resultAllDrink.size());
    }

    @Test
    void addDrinkFailIdNull() {
        Drink drink = new Drink("Bier", "alcohol", 500);
        Assertions.assertFalse(bar.addDrink(null,drink));
    }

    @Test
    void addDrinkFailDrinkNull() {
        Assertions.assertFalse(bar.addDrink("1",null));
    }

    @Test
    void getDrinkSuccess() {
        Drink drink = new Drink("Bier", "alcohol", 500);
        Assertions.assertTrue(bar.addDrink("1",drink));
        Assertions.assertNotNull(bar.getDrink("1"));
        Assertions.assertEquals(drink,bar.getDrink("1"));
    }

    @Test
    void getDrinkFail() {
    Assertions.assertNull(bar.getDrink("2"));
    }

    @Test
    void getBarCollection() {
        Assertions.assertNotNull(bar.getBarCollection());
    }
}