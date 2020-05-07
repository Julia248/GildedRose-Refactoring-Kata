package com.gildedrose;

public class BackstagePasses extends Item {

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update(){
        if (this.sellIn < 1) {
            this.quality = 0;
            return;
        }

        if (this.sellIn < 6) {
            this.quality = this.quality + 3;
            return;
        }

        if (this.sellIn < 11) {
            this.quality = this.quality + 2;
            return;
        }

        this.quality = this.quality + 1;
    }
}

