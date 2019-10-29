package com.gildedrose;

import com.gildedrose.processor.ItemProcessor;
import com.gildedrose.processor.ProcessorRegistry;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemProcessor processor = ProcessorRegistry.getProcessor(item);
            processor.processItem(item);
        }
    }
}