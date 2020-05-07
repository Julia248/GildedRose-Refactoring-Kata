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
        if (!this.name.equals("Aged Brie")
                && !this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (this.quality > 0) {
                if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
                    this.quality = this.quality - 1;
                }
            }
        } else {
            if (this.quality < 50) {
                this.quality = this.quality + 1;

                if (this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (this.sellIn < 11) {
                        if (this.quality < 50) {
                            this.quality = this.quality + 1;
                        }
                    }

                    if (this.sellIn < 6) {
                        if (this.quality < 50) {
                            this.quality = this.quality + 1;
                        }
                    }
                }
            }
        }

        if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
            this.sellIn = this.sellIn - 1;
        }

        if (this.sellIn < 0) {
            if (!this.name.equals("Aged Brie")) {
                if (!this.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (this.quality > 0) {
                        if (!this.name.equals("Sulfuras, Hand of Ragnaros")) {
                            this.quality = this.quality - 1;
                        }
                    }
                } else {
                    this.quality = this.quality - this.quality;
                }
            } else {
                if (this.quality < 50) {
                    this.quality = this.quality + 1;
                }
            }
        }
    }
}
