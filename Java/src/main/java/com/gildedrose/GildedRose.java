package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                if (item.quality < 50) {
                    increaseQuality(item);
                }
                item.sellIn = item.sellIn - 1;
                if (item.quality < 50 && item.sellIn < 0) {
                    increaseQuality(item);
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
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
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                if (item.quality > 0) {
                    decreaseQuality(item);
                }
                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0 && item.quality > 0) {
                    decreaseQuality(item);
                }
                break;
        }
    }

    private static void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private static void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
