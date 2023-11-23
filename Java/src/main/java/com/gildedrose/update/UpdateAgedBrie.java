package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateAgedBrie implements UpdateItem {
    private final Item item;

    public UpdateAgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        increaseQuality(item);

        decreaseSellIn(item);

        if (isExpired(item)) {
            increaseQuality(item);
        }

    }
}
