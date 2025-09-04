package com.magasin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KryptoniteTest {

    @Test
    void kryptonite_nao_muda() {
        Item[] items = { new Item("Kryptonite", 0, 80) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }
}
