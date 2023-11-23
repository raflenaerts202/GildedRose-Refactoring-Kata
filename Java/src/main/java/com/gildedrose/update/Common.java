package com.gildedrose.update;

import com.gildedrose.Item;

public class Common implements ItemUpdate {
    private final Item item;

    public Common(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
        }

    }
}
