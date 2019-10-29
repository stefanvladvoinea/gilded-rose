package com.gildedrose.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;
import com.gildedrose.processor.items.ConjuredItem;

/**
 * Item processor for conjured items
 * 
 * @author stefan
 *
 */
class ConjuredItemProcessor extends ItemProcessor {

    private final static Logger log = LoggerFactory.getLogger(ConjuredItemProcessor.class);

    ConjuredItemProcessor() {
        super(ConjuredItem.LABEL);
    }

    @Override
    public void processItem(Item item) {
        item.sellIn--;
        log.debug("Sell in decreased {}", item.sellIn);
        if (item.sellIn >= 0) {
            item.quality = Math.max(item.quality -= 2, 0);
            log.debug("Quality decreased by 2 {}", item.quality);
        } else {
            item.quality = Math.max(item.quality -= 4, 0);
            log.debug("Quality decreased by 4 {}", item.quality);
        }
    }

}
