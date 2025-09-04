package com.magasin;

import org.junit.jupiter.api.Test;
import java.nio.file.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class GoldenMasterTest {

    @Test
    void goldenMaster_deve_bater_com_arquivo() throws Exception {
        List<Item> items = itemsIniciais();
        String output = simulaDias(items, 30);

        Path gm = Paths.get("src/test/resources/golden-master.txt");
        if (!Files.exists(gm)) {
            Files.createDirectories(gm.getParent());
            Files.writeString(gm, output);
            fail("Golden Master criado em " + gm + ". Revise/commite e rode novamente.");
        }

        String expected = Files.readString(gm);
        assertEquals(expected, output);
    }

    private static List<Item> itemsIniciais() {
        return new ArrayList<>(List.of(
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Comté", 2, 0),
                new Item("Pass VIP Concert", 15, 20),
                new Item("Kryptonite", 0, 80),
                new Item("Kryptonite", -1, 80),
                new Item("Elixir of the Mongoose", 5, 7)
        ));
    }

    private static String simulaDias(List<Item> items, int dias) {
        StringBuilder sb = new StringBuilder();
        Magasin app = new Magasin(items.toArray(new Item[0]));
        for (int day = 0; day < dias; day++) {
            sb.append("-------- dia ").append(day).append(" --------\n");
            sb.append("name, sellIn, quality\n");
            for (Item item : app.items) {
                sb.append(item.name).append(", ").append(item.sellIn).append(", ").append(item.quality).append("\n");
            }
            app.updateQuality();
        }
        return sb.toString();
    }
}
