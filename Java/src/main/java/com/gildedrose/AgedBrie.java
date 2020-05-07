package com.gildedrose;


public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
        if (this.sellIn > 0) {
            this.sellIn = this.sellIn - 1;
        }
    }
}
