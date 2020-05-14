package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    void shouldNeverNegativeQualityAnyProduct() {
        Item[] items = new Item[] {
                Item.getItemByType("Chocolate", 1, 1),
                Item.getItemByType("Aged Brie", 1 ,1),
                Item.getItemByType("Sulfuras, Hand of Ragnaros", 1, 1),
                Item.getItemByType("Backstage passes to a TAFKAL80ETC concert", 1 ,1),
                Item.getItemByType("Conjured", 1, 1),
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
        assertEquals(0, app.items[3].quality);
        assertEquals(0, app.items[4].quality);
    }

    @Test
    void shouldIncreaseQualityForAgedBrie() {
        Item[] items = new Item[] {
                Item.getItemByType("Aged Brie", 1, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void shouldNotIncreaseQualityAnyProductOver50() {
        Item[] items = new Item[] {
                Item.getItemByType("Aged Brie", 1, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void shouldNotDecreaseQualityOrSellSulfuras() {
        Item[] items = new Item[] {
                Item.getItemByType("Sulfuras, Hand of Ragnaros", 2, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    void shouldIncreaseBackstageQualityTwice() {
        Item[] items = new Item[] {
                Item.getItemByType("Backstage passes to a TAFKAL80ETC concert", 9, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 12, app.items[0].quality);
    }

    @Test
    void shouldIncreaseBackstageQualityOnce() {
        Item[] items = new Item[] {
                Item.getItemByType("Backstage passes to a TAFKAL80ETC concert", 11, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 11, app.items[0].quality);
    }

    @Test
    void shouldIncreaseBackstageQualityThree() {
        Item[] items = new Item[] {
                Item.getItemByType("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 13, app.items[0].quality);
    }

    @Test
    void shouldDropsToZeroBackstageQuality() {
        Item[] items = new Item[] {
                Item.getItemByType("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 0, app.items[0].quality);
    }

    @Test
    void shouldAnyProductDatePassedDecreaseQualityTwice() {
        Item[] items = new Item[] {
                Item.getItemByType("Cholocate", -1, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 8, app.items[0].quality);
    }

    @Disabled
    @Test
    void shouldAddQualityOnceForBackstagePasses() {
        Item[] items = new Item[] {
                Item.getItemByType("Backstage passes to a TAFKAL80ETC concert", 14, 15)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 16, app.items[0].quality);
    }

    @Test
    void shouldAddQualityTwiceForConjured() {
        Item[] items = new Item[] {
                Item.getItemByType("Conjured", 10, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 8, app.items[0].quality);
    }

}
