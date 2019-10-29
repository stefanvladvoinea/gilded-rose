package com.gildedrose.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;

/**
 * Item processor for Backstage passes items
 * 
 * @author stefan
 *
 */
class BackstagePassItemProcessor extends ItemProcessor {

    private final static Logger log = LoggerFactory.getLogger(BackstagePassItemProcessor.class);

    public final static String LABEL = "Backstage passes to a TAFKAL80ETC concert";

    BackstagePassItemProcessor() {
        super(LABEL);
    }

    @Override
    public void processItem(Item item) {
        item.sellIn--;
        log.debug("Sell in decreased {}", item.sellIn);
        if (item.sellIn < 0) {
            item.quality = 0;
            log.debug("Quality dropped to 0");
        } else if (item.sellIn <= 5) {
            item.quality = Math.min(item.quality += 3, 50);
            log.debug("Quality increased by 3 {}", item.quality);
        } else if (item.sellIn <= 10) {
            item.quality = Math.min(item.quality += 2, 50);
            log.debug("Quality increased by 2 {}", item.quality);
        } else {
            item.quality = Math.min(++item.quality, 50);
            log.debug("Quality increased by 1 {}", item.quality);
        }
    }

}
