package com.gildedrose.update;

import com.gildedrose.Item;

public interface UpdateItem {
    void update();

    default boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    default void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }

    default void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    default void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

}
