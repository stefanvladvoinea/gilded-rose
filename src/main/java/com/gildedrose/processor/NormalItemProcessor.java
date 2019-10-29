package com.gildedrose.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;

/**
 * Item processor for normal items (default)
 * 
 * @author stefan
 *
 */
class NormalItemProcessor extends ItemProcessor {

    private final static Logger log = LoggerFactory.getLogger(NormalItemProcessor.class);

    public final static String LABEL = "NormalItem";

    NormalItemProcessor() {
        super(LABEL);
    }

    @Override
    public void processItem(Item item) {
        item.sellIn--;
        log.debug("Sell in decreased {}", item.sellIn);
        if (item.sellIn >= 0) {
            item.quality = Math.max(--item.quality, 0);
            log.debug("Quality decreased by 1 {}", item.quality);
        } else {
            item.quality = Math.max(item.quality -= 2, 0);
            log.debug("Quality decreased by 2 {}", item.quality);
        }
    }

}
