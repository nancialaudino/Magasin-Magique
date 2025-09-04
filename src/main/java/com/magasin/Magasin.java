package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            // Pouvoirs magiques
            if ("Pouvoirs magiques".equals(item.name)) {
                item.sellIn--;
                int decrement = item.sellIn < 0 ? 4 : 2; // 2x antes da validade, 4x depois
                item.quality = Math.max(0, item.quality - decrement);
                continue; // pula o restante da lógica
            }

            // Kryptonite não muda
            if (item.name.equals("Kryptonite")) continue;

            // Comté aumenta de qualidade
            if (item.name.equals("Comté")) {
                if (item.quality < 50) item.quality++;
            }
            // Pass VIP Concert aumenta de forma especial
            else if (item.name.equals("Pass VIP Concert")) {
                if (item.quality < 50) item.quality++;
                if (item.sellIn <= 10 && item.quality < 50) item.quality++;
                if (item.sellIn <= 5 && item.quality < 50) item.quality++;
            }
            // Itens normais
            else {
                if (item.quality > 0) item.quality--;
            }

            // Atualiza sellIn
            item.sellIn--;

            // Após validade
            if (item.sellIn < 0) {
                if (item.name.equals("Comté")) {
                    if (item.quality < 50) item.quality++;
                } else if (item.name.equals("Pass VIP Concert")) {
                    item.quality = 0;
                } else {
                    if (item.quality > 0) item.quality--;
                }
            }
        }
    }
}
