package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateCommon implements UpdateItem {
    private final Item item;

    public UpdateCommon(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseQuality(item);

        decreaseSellIn(item);

        if (isExpired(item)) {
            decreaseQuality(item);
        }
    }
}
