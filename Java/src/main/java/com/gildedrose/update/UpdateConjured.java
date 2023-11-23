package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateConjured implements UpdateItem {
    private final Item item;

    public UpdateConjured(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseQuality(item);
        decreaseQuality(item);

        decreaseSellIn(item);

        if (isExpired(item)) {
            decreaseQuality(item);
            decreaseQuality(item);
        }

    }
}
