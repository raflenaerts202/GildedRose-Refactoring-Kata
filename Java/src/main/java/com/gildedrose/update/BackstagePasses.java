package com.gildedrose.update;

import com.gildedrose.Item;

public class BackstagePasses implements ItemUpdate {
    private final Item item;

    public BackstagePasses(Item item) {
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
