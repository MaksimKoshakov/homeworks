package de.ait.homework40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void getName() {
        Drink drink = new Drink("Bier", "alcohol", 500);
        Assertions.assertEquals("Bier", drink.getName());
    }

    @Test
    void getType() {
        Drink drink = new Drink("Bier", "alcohol", 500);
        Assertions.assertEquals("alcohol", drink.getType());
    }

    @Test
    void getVolume() {
        Drink drink = new Drink("Bier", "alcohol", 500);
        Assertions.assertEquals(500, drink.getVolume());
    }

    @Test
    void setVolume() {
        Drink drink = new Drink("Bier", "alcohol", 500);
        drink.setVolume(400);
        Assertions.assertEquals(400, drink.getVolume());
    }
}