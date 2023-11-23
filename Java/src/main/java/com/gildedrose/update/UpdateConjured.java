package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateConjured implements UpdateItem {
    private final Item item;

    public UpdateConjured(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality > 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality > 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }

    }
}
