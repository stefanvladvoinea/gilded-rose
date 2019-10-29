package com.gildedrose.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;
import com.gildedrose.processor.items.SulfurasItem;

/**
 * Item processor for Sulfuras items
 * 
 * @author stefan
 *
 */
class SulfurasItemProcessor extends ItemProcessor {

    private final static Logger log = LoggerFactory.getLogger(SulfurasItemProcessor.class);

    SulfurasItemProcessor() {
        super(SulfurasItem.LABEL);
    }

    @Override
    public void processItem(Item item) {
        log.debug("Do nothing. Item remains the same {}", item);
    }

}
