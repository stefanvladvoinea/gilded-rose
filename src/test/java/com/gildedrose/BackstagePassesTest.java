package com.gildedrose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackstagePassesTest {

    private static final Logger log = LoggerFactory.getLogger(BackstagePassesTest.class);

    @Test
    public void qualityIncremenetsOneEachDay() {
        log.info("Test if backstage pass items quality increments with one unit if sell in is greater than 10");
        int initialQuality = 10;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 20, initialQuality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.sellIn > 11) {
            app.updateQuality();
            log.debug("Item: {}", item);
            assertEquals(++initialQuality, item.quality);
        }
    }

    @Test
    public void qualityStaysPositive() {
        log.info("Test if backstage pass items quality is always positive");
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.sellIn > -10) {
            app.updateQuality();
            log.debug("Item: {}", item);
            assertTrue(item.quality >= 0);
        }
    }

    @Test
    public void qualityIncrementsFast() {
        log.info("Test if backstage pass items quality increments with 2 units after the sellIn is between 10 and 5" + " and by 3 units after");
        int initialQuality = 20;
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, initialQuality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        while (item.sellIn > -20) {
            app.updateQuality();
            log.debug("Item: {}", item);
            if (item.sellIn > 10) {
                assertEquals(++initialQuality, item.quality);
            } else if (item.sellIn > 5) {
                assertEquals(Math.min(initialQuality += 2, 50), item.quality);
            } else if (item.sellIn > 0) {
                assertEquals(Math.min(initialQuality += 3, 50), item.quality);
            } else if (item.sellIn < 0) {
                assertEquals(0, item.quality);
            }
        }
    }

}
