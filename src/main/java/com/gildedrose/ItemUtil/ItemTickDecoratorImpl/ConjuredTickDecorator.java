package com.gildedrose.ItemUtil.ItemTickDecoratorImpl;

import com.gildedrose.Item;
import com.gildedrose.ItemUtil.ItemTickDecorator;

import static com.gildedrose.GildedRose.LOWER_BOUND_QUALITY;

public class ConjuredTickDecorator extends ItemTickDecorator {
    public ConjuredTickDecorator(Item item) {
        super(item);
    }

    @Override
    protected int calcNewQuality(){
        int newQualityUnbounded;
        if(item.sellIn<1){
            newQualityUnbounded = item.quality - 4;
        } else {
            newQualityUnbounded = item.quality - 2;
        }
        return Math.max(newQualityUnbounded, LOWER_BOUND_QUALITY);
    }

}
