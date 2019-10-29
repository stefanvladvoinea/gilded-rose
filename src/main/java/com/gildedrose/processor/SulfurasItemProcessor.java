package com.gildedrose.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;

/**
 * Item processor for Sulfuras items
 * 
 * @author stefan
 *
 */
class SulfurasItemProcessor extends ItemProcessor {

    private final static Logger log = LoggerFactory.getLogger(SulfurasItemProcessor.class);

    public final static String LABEL = "Sulfuras, Hand of Ragnaros";

    SulfurasItemProcessor() {
        super(LABEL);
    }

    @Override
    public void processItem(Item item) {
        log.debug("Do nothing. Item remains the same {}", item);
    }

}
