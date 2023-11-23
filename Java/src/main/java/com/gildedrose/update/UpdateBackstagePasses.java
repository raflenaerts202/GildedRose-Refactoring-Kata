package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateBackstagePasses implements UpdateItem {
    private final Item item;

    public UpdateBackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality < 50) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }

    }
}
