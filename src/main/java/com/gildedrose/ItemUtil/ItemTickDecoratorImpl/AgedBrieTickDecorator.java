package com.gildedrose.ItemUtil.ItemTickDecoratorImpl;

import com.gildedrose.Item;
import com.gildedrose.ItemUtil.ItemTickDecorator;

import static com.gildedrose.GildedRose.UPPER_BOUND_QUALITY;

public class AgedBrieTickDecorator extends ItemTickDecorator {
    public AgedBrieTickDecorator(Item item) {
        super(item);
    }

    @Override
    protected int calcNewQuality(){
        int newQualityUnbounded;
        if(item.sellIn<1){
            newQualityUnbounded = item.quality + 2;
        } else {
            newQualityUnbounded = item.quality + 1;
        }
        return Math.min(newQualityUnbounded, UPPER_BOUND_QUALITY);
    }


}
