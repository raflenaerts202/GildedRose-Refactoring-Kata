package com.gildedrose.update;

import com.gildedrose.Item;

public interface ItemUpdate {
    void update();

    default void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    default void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

}
