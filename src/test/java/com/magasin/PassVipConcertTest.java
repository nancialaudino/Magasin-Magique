package com.magasin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassVipConcertTest {

    @Test
    void passVIP_aumenta_qualidade_corretamente() {
        Item[] items = { new Item("Pass VIP Concert", 15, 20) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }
}
