package com.gildedrose.ItemUtil;

import com.gildedrose.Item;
import com.gildedrose.ItemUtil.ItemTickDecoratorImpl.*;

public class ItemTickDecoratorFactory{
    public static ItemTickDecorator createItemTickDecorator(Item item) {
        if(item.name.startsWith("Sulfuras")){
            return new SulfurasTickDecorator(item);
        } else if (item.name.startsWith("Backstage passes")) {
            return new BackstagePassTickDecorator(item);
        } else if (item.name.startsWith("Aged Brie")){
            return new AgedBrieTickDecorator(item);
        } else if (item.name.startsWith("Conjured")){
            return new ConjuredTickDecorator(item);
        } else {
            return new NormalItemTickDecorator(item);
        }
    }
}
