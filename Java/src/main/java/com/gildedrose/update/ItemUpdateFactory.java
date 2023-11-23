package com.gildedrose.update;

import com.gildedrose.Item;

public class ItemUpdateFactory {
    public ItemUpdate create(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePasses(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            default:
                return new Common(item);
        }
    }
}
