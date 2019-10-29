package com.gildedrose.processor.items;

import com.gildedrose.Item;

public class NormalItem extends Item {

    public final static String LABEL = "NormalItem";

    public NormalItem(int sellIn, int quality) {
        super(LABEL, sellIn, quality);
    }

}
