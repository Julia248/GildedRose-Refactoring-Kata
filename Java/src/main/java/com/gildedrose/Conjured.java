package com.gildedrose;

public class Conjured extends Item {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void update(){

        this.quality=this.quality - 2;

    }
}
