package com.magasin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PouvoirsMagiquesTest {

    @Test
    void degrada_2x_normal_antes_validade() {
        Item[] items = { new Item("Pouvoirs magiques", 3, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(2, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void degrada_4x_apos_validade() {
        Item[] items = { new Item("Pouvoirs magiques", 0, 10) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void qualidade_nao_negativa() {
        Item[] items = { new Item("Pouvoirs magiques", 1, 1) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }
}
