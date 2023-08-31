package com.gildedrose.ItemUtil.ItemTickDecoratorImpl;

import com.gildedrose.Item;
import com.gildedrose.ItemUtil.ItemTickDecorator;
import static com.gildedrose.GildedRose.UPPER_BOUND_QUALITY;
public class BackstagePassTickDecorator extends ItemTickDecorator {
    public BackstagePassTickDecorator(Item item) {
        super(item);
    }

    @Override
    protected int calcNewQuality(){
        int newQualityUnbounded;
        if(item.sellIn<1){
           newQualityUnbounded = 0;
        } else if (item.sellIn<6) {
            newQualityUnbounded = item.quality + 3;
        } else if (item.sellIn<11) {
            newQualityUnbounded = item.quality + 2;
        } else {
            newQualityUnbounded = item.quality + 1;
        }
        return Math.min(newQualityUnbounded, UPPER_BOUND_QUALITY);
    }

}
