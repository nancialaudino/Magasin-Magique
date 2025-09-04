package com.magasin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NormalItemTest {

    @Test
    void normalItem_degrada_1_por_dia() {
        Item[] items = { new Item("Elixir of the Mongoose", 5, 7) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }
}
