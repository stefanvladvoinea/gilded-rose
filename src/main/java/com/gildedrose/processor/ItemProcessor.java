package com.gildedrose.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;

/**
 * Item processor base class
 * 
 * @author stefan
 *
 */
public abstract class ItemProcessor {

    private final static Logger log = LoggerFactory.getLogger(ItemProcessor.class);

    private final String label;

    public ItemProcessor(String label) {
        log.info("Creating processor {}", label);
        this.label = label;
    }

    /**
     * Process the item in a business specific way
     * 
     * @param item the item to be processed
     */
    public abstract void processItem(Item item);

    /**
     * Get the label of items for which the processor is responsible  
     * 
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "ItemProcessor [label=" + label + "]";
    }

}
