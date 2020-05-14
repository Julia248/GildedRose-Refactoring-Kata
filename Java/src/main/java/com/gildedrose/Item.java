package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item getItemByType(String name, int sellIn, int quality){
        if (name == "Aged Brie") {
            return new AgedBrie(name, sellIn, quality);
        }

        if (name == "Sulfuras, Hand of Ragnaros") {
            return new Sulfuras(name, sellIn, quality);
        }

        if (name == "Backstage passes to a TAFKAL80ETC concert") {
            return new BackstagePasses(name, sellIn, quality);
        }

        if (name == "Conjured") {
            return new Conjured(name, sellIn, quality);
        }

        return new Item(name, sellIn, quality);
    }


    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void update() {
        if (this.quality < 1) {
            return;
        }
        this.quality = this.quality-1;
    }
}
