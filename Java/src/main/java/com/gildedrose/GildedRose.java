package com.gildedrose;

import com.gildedrose.update.UpdateItemFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            new UpdateItemFactory().create(item).update();
        }
    }
}
