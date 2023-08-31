package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void nameUnchanged() {
        GildedRose app = newAppWithOneItem(new Item("foo", 10, 5));
        app.tick();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void normalItemTimePassed() {
        GildedRose app = newAppWithOneItem(new Item("foo", 10, 5));
        app.tick();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void normalItemDegrades() {
        GildedRose app = newAppWithOneItem(new Item("foo", 10, 5));
        app.tick();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void normalItemDegradesPastDate() {
        GildedRose app = newAppWithOneItem(new Item("foo", -2, 5));
        app.tick();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void normalItemQualityLowerBound() {
        GildedRose app = newAppWithOneItem(new Item("foo", 10, 0));
        app.tick();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sulfurasNotDegrades(){
        GildedRose app = newAppWithOneItem(new Item("Sulfuras, Hand of Ragnaros", 10, 80));
        app.tick();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void sulfurasNotChangesSellIn(){
        GildedRose app = newAppWithOneItem(new Item("Sulfuras, Hand of Ragnaros", 10, 80));
        app.tick();
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void agedBrieImprovesBeforeDate(){
        GildedRose app = newAppWithOneItem(new Item("Aged Brie", 2, 0));
        app.tick();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void agedBrieImprovesPastDate(){
        GildedRose app = newAppWithOneItem(new Item("Aged Brie", -1, 0));
        app.tick();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void agedBrieQualityUpperBound() {
        GildedRose app = newAppWithOneItem(new Item("Aged Brie", 10, 50));
        app.tick();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassImprovesBefore(){
        GildedRose app = newAppWithOneItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0));
        app.tick();
        assertEquals(1, app.items[0].quality);
    }
    @Test
    void backstagePassImprovesTenDayBefore(){
        GildedRose app = newAppWithOneItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0));
        app.tick();
        assertEquals(2, app.items[0].quality);
    }
    @Test
    void backstagePassImprovesFiveDayBefore(){
        GildedRose app = newAppWithOneItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0));
        app.tick();
        assertEquals(3, app.items[0].quality);
    }
    @Test
    void backstagePassWorthlessAfter(){
        GildedRose app = newAppWithOneItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50));
        app.tick();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredItemTwiceBeforeDate(){
        GildedRose app = newAppWithOneItem(new Item("Conjured Mana Cake", 5, 50));
        app.tick();
        assertEquals(48, app.items[0].quality);
    }

    @Test
    void conjuredItemTwiceAfterDate(){
        GildedRose app = newAppWithOneItem(new Item("Conjured Mana Cake", 0, 50));
        app.tick();
        assertEquals(46, app.items[0].quality);
    }

    private GildedRose newAppWithOneItem(Item item){
        Item[] items = new Item[] {item};
        return new GildedRose(items);
    }
}
