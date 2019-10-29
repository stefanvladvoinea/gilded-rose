package com.gildedrose.processor.items;

import com.gildedrose.Item;

public class ConjuredItem extends Item {

    public final static String LABEL = "Conjured";

    public ConjuredItem(int sellIn, int quality) {
        super(LABEL, sellIn, quality);
    }

}
