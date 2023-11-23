package com.gildedrose.update;

import com.gildedrose.Item;

public class UpdateItemFactory {
    public UpdateItem create(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new UpdateAgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new UpdateBackstagePasses(item);
            case "Sulfuras, Hand of Ragnaros":
                return new UpdateSulfuras(item);
            case "Conjured Mana Cake":
                return new UpdateConjured(item);
            default:
                return new UpdateCommon(item);
        }
    }
}
