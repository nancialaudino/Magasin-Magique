package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            // Pouvoirs magiques
            if ("Pouvoirs magiques".equals(item.name)) {
                updatePouvoirsMagiques(item);
                continue;
            }

            // Kryptonite não muda
            if ("Kryptonite".equals(item.name)) continue;

            // Comté
            if ("Comté".equals(item.name)) {
                updateComte(item);
            }
            // Pass VIP Concert
            else if ("Pass VIP Concert".equals(item.name)) {
                updatePassVIP(item);
            }
            // Item normal
            else {
                updateNormalItem(item);
            }
        }
    }

    // ---------------- Métodos auxiliares ---------------- //

    private void updateNormalItem(Item item) {
        if (item.quality > 0) item.quality--;

        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }

    private void updateComte(Item item) {
        if (item.quality < 50) item.quality++;

        item.sellIn--;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }

    private void updatePassVIP(Item item) {
        if (item.quality < 50) item.quality++;

        if (item.sellIn <= 10 && item.quality < 50) item.quality++;
        if (item.sellIn <= 5 && item.quality < 50) item.quality++;

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updatePouvoirsMagiques(Item item) {
        item.sellIn--;

        int decrement = item.sellIn < 0 ? 4 : 2;
        item.quality = Math.max(0, item.quality - decrement);
    }
}
