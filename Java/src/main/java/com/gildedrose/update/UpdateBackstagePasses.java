package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateBackstagePasses implements UpdateItem {
    private final Item item;

    public UpdateBackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

        decreaseSellIn(item);

        if (isExpired(item)) {
            item.quality = 0;
        }

    }
}
