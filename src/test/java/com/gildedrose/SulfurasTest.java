package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SulfurasTest {

    private static final Logger log = LoggerFactory.getLogger(SulfurasTest.class);

    @Test
    public void qualityStaysTheSame() {
        log.info("Test if sulfuras items quality and sell in stays the same");
        int initialQuality = 10;
        int initialSellIn = 10;
        Item item = new Item("Sulfuras, Hand of Ragnaros", initialSellIn, initialQuality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        int counter = 20;
        while (counter-- > 0) {
            app.updateQuality();
            log.debug("Item: {}", item);
            assertEquals(initialQuality, item.quality);
            assertEquals(initialSellIn, item.sellIn);
        }
    }

}
