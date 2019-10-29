package com.gildedrose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConjuredItemsTest {

    private static final Logger log = LoggerFactory.getLogger(ConjuredItemsTest.class);

    @Test
    public void qualityDecrementsOneEachDay() {
        log.info("Test if conjured items quality decrements with one unit");
        int initialQuality = 10;
        Item item = new Item("Conjured", 10, initialQuality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.quality > 0) {
            app.updateQuality();
            log.debug("Item: {}", item);
            assertEquals(initialQuality -= 2, item.quality);
        }
    }

    @Test
    public void qualityStaysPositive() {
        log.info("Test if conjured items quality is always positive");
        Item item = new Item("Conjured", 10, 5);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.sellIn > -10) {
            app.updateQuality();
            log.debug("Item: {}", item);
            assertTrue(item.quality >= 0);
        }
    }

    @Test
    public void qualityDecremetsTwiceAsFast() {
        log.info("Test if conjured items quality decrements with 2 units after the sellIn is below 0");
        int initialQuality = 20;
        Item item = new Item("Conjured", 5, initialQuality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.quality > 0) {
            app.updateQuality();
            log.debug("Item: {}", item);
            if (item.sellIn >= 0) {
                assertEquals(initialQuality -= 2, item.quality);
            } else {
                assertEquals(Math.max(initialQuality = initialQuality - 4, 0), item.quality);
            }
        }
    }

}
