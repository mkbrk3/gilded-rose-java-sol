package com.gildedrose.ItemUtil;

import com.gildedrose.Item;

public abstract class ItemTickDecorator {
    public Item item;

    public ItemTickDecorator(Item item){
        this.item = item;
    }

    protected abstract int calcNewQuality();

    public void tick(){
        item.quality = calcNewQuality();
        item.sellIn--;
    }
}
