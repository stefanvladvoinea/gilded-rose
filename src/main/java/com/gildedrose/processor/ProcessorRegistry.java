package com.gildedrose.processor;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.Item;
import com.gildedrose.processor.items.NormalItem;

/**
 * Keep track of item processors
 * 
 * @author stefan
 *
 */
public abstract class ProcessorRegistry {

    private static final Logger log = LoggerFactory.getLogger(ProcessorRegistry.class);

    private static final Map<String, ItemProcessor> processorsMap = new HashMap<>();

    static {
        registerProcessor(NormalItemProcessor.class);
        registerProcessor(AgedBrieItemProcessor.class);
        registerProcessor(SulfurasItemProcessor.class);
        registerProcessor(BackstagePassItemProcessor.class);
        registerProcessor(ConjuredItemProcessor.class);
    }

    private static void registerProcessor(Class<? extends ItemProcessor> processorClass) {
        try {
            log.info("Register processor {}", processorClass);
            ItemProcessor itemProcessor = processorClass.newInstance();
            processorsMap.put(itemProcessor.getLabel(), itemProcessor);
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("Unable to create processor for class {}", processorClass, e);
        }
    }

    /**
     * Offers a processor specific for the item passed as parameter.
     * If no particular processor is found in the registry the default (normal items)
     * processor is offered.
     * 
     * @param item the item for which the processor should be offered
     * @return the corresponding processor
     */
    public static final ItemProcessor getProcessor(Item item) {
        log.debug("Get processor for item {}", item);
        ItemProcessor itemProcessor = processorsMap.get(item.name);
        if (itemProcessor == null) {
            log.debug("No dedicated processor for item {}, falling back to default one", item);
            itemProcessor = processorsMap.get(NormalItem.LABEL);
        }
        log.debug("Selected processor {}", itemProcessor);
        return itemProcessor;
    }

}
