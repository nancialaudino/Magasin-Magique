package com.magasin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComteTest {

    @Test
    void comte_aumenta_qualidade() {
        Item[] items = { new Item("Comté", 2, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals(1, items[0].quality);
    }
}
