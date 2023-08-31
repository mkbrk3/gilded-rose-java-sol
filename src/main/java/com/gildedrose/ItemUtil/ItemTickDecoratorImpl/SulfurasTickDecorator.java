package com.gildedrose.ItemUtil.ItemTickDecoratorImpl;

import com.gildedrose.Item;
import com.gildedrose.ItemUtil.ItemTickDecorator;

public class SulfurasTickDecorator extends ItemTickDecorator {
    public SulfurasTickDecorator(Item item){
        super(item);
    }

    @Override
    protected int calcNewQuality() {
        return 80;
    }

    @Override
    public void tick() {}

}
