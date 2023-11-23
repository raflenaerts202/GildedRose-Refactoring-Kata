package com.gildedrose;

import com.gildedrose.update.ItemUpdateFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            new ItemUpdateFactory().create(item).update();
        }
    }
}
