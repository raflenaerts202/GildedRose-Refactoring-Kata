package com.gildedrose.update;

import com.gildedrose.Item;

public class AgedBrie implements ItemUpdate {
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality < 50) {
            increaseQuality(item);
        }
        item.sellIn = item.sellIn - 1;
        if (item.quality < 50 && item.sellIn < 0) {
            increaseQuality(item);
        }

    }
}
