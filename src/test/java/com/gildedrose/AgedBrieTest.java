package com.gildedrose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gildedrose.processor.items.AgedBrieItem;

public class AgedBrieTest {

    private static final Logger log = LoggerFactory.getLogger(AgedBrieTest.class);

    @Test
    public void qualityIncremenetsOneEachDay() {
        log.info("Test if aged brie items quality increments with one unit");
        int initialQuality = 10;
        Item item = new AgedBrieItem(10, initialQuality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.sellIn > 0) {
            app.updateQuality();
            log.debug("Item: {}", item);
            assertEquals(++initialQuality, item.quality);
        }
    }

    @Test
    public void qualityStaysPositive() {
        log.info("Test if aged brie items quality is always positive");
        Item item = new AgedBrieItem(10, 5);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.sellIn > -10) {
            app.updateQuality();
            log.debug("Item: {}", item);
            assertTrue(item.quality >= 0);
        }
    }

    @Test
    public void qualityIncrementsTwiceAsFast() {
        log.info("Test if aged brie items quality increments with 2 units after the sellIn is below 0 but never goes over 50");
        int initialQuality = 20;
        Item item = new AgedBrieItem(5, initialQuality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.sellIn > -20) {
            app.updateQuality();
            log.debug("Item: {}", item);
            if (item.sellIn >= 0) {
                assertEquals(++initialQuality, item.quality);
            } else {
                assertEquals(Math.min(initialQuality += 2, 50), item.quality);
            }
        }
    }

}
