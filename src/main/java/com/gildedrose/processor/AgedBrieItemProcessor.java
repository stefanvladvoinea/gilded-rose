package com.gildedrose.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;

/**
 * Item processor for Aged Brie items
 * 
 * @author stefan
 *
 */
class AgedBrieItemProcessor extends ItemProcessor {

    private final static Logger log = LoggerFactory.getLogger(AgedBrieItemProcessor.class);

    public final static String LABEL = "Aged Brie";

    AgedBrieItemProcessor() {
        super(LABEL);
    }

    @Override
    public void processItem(Item item) {
        item.sellIn--;
        log.debug("Sell in decreased {}", item.sellIn);
        if (item.sellIn >= 0) {
            item.quality = Math.min(item.quality += 1, 50);
            log.debug("Quality increased by 1 {}", item.quality);
        } else {
            item.quality = Math.min(item.quality += 2, 50);
            log.debug("Quality increased by 2 {}", item.quality);
        }
    }

}
