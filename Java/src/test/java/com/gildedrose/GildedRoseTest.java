package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {
    @Test
    void qualityAndSellInIsLoweredAfterEachDay2() {
        String name = "Flamegrinder";
        int sellIn = 5;
        int quality = 10;

        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(quality - 1, items[0].quality);
        assertEquals(sellIn - 1, items[0].sellIn);
    }

    @Test
    void qualityDegradesTwiceAsFastAfterSellByDate() {
        String name = "Flamegrinder";
        int quality = 10;

        int degradationNoSellIn = getDegradationAfterUpdateQuality(name, 0, quality);
        int degradationWithSellIn = getDegradationAfterUpdateQuality(name, 5, quality);

        assertEquals(degradationNoSellIn, 2 * degradationWithSellIn);
    }

    private static int getDegradationAfterUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return quality - app.items[0].quality;
    }

    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[] {
            new Item("Hellrender", 5, 10),
            new Item("Aged Brie", 5, 10),
            new Item("Sulfuras, Hand of Ragnaros", 5, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        };
        GildedRose app = new GildedRose(items);
        IntStream.range(0, 20).forEach($ -> {
            int sellInBeforeUpdate = app.items[0].sellIn;

            app.updateQuality();

            assertTrue(app.items[0].quality >= 0);
            assertTrue(app.items[1].quality >= 0);
            assertTrue(app.items[2].quality >= 0);
            assertTrue(app.items[3].quality >= 0);
            assertEquals(sellInBeforeUpdate - 1, app.items[0].sellIn);
        });
    }

    @Test
    void qualityOfAgedBrieIncreasesUntilFifty() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        int index = 0;
        do {
            int qualityBeforeUpdate = app.items[0].quality;
            int sellInBeforeUpdate = app.items[0].sellIn;

            app.updateQuality();

            if (qualityBeforeUpdate == 50) {
                assertEquals(50, app.items[0].quality);
            } else if (app.items[0].sellIn < 0) {
                assertEquals(qualityBeforeUpdate + 2, app.items[0].quality);
            } else {
                assertEquals(qualityBeforeUpdate + 1, app.items[0].quality);
            }
            assertEquals(sellInBeforeUpdate - 1, app.items[0].sellIn);
            index += 1;
        } while (index < 50);

    }

    @Test
    void qualityOfLegendaryItemDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 10) };
        GildedRose app = new GildedRose(items);
        int index = 0;
        do {
            int qualityBeforeUpdate = app.items[0].quality;
            int sellInBeforeUpdate = app.items[0].sellIn;

            app.updateQuality();

            assertEquals(qualityBeforeUpdate, app.items[0].quality);
            assertEquals(sellInBeforeUpdate, app.items[0].sellIn);
            index += 1;
        } while (index < 50);
    }

    @Test
    void qualityOfBackstagePassesIncreasesUntilFifty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10) };
        GildedRose app = new GildedRose(items);
        int index = 0;
        do {
            int qualityBeforeUpdate = app.items[0].quality;
            int sellInBeforeUpdate = app.items[0].sellIn;

            app.updateQuality();

            if (sellInBeforeUpdate < 1) {
                assertEquals(0, app.items[0].quality);
            } else if (qualityBeforeUpdate == 50) {
                assertEquals(50, app.items[0].quality);
            } else if (sellInBetween(sellInBeforeUpdate, 0, 5)) {
                assertEquals(qualityBeforeUpdate + 3, app.items[0].quality);
            } else if (sellInBetween(sellInBeforeUpdate, 5, 10)) {
                assertEquals(qualityBeforeUpdate + 2, app.items[0].quality);
            } else {
                assertEquals(qualityBeforeUpdate + 1, app.items[0].quality);
            }

            assertEquals(sellInBeforeUpdate - 1, app.items[0].sellIn);

            index += 1;
        } while (index < 50);
    }

    private static boolean sellInBetween(int sellIn, int low, int high) {
        return sellIn <= high && sellIn > low;
    }

}
