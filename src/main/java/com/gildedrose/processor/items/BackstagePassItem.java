package com.gildedrose.processor.items;

import com.gildedrose.Item;

public class BackstagePassItem extends Item {

    public final static String LABEL = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePassItem(int sellIn, int quality) {
        super(LABEL, sellIn, quality);
    }

}
