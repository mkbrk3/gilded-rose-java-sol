package com.gildedrose;

import com.gildedrose.ItemUtil.ItemTickDecorator;
import com.gildedrose.ItemUtil.ItemTickDecoratorFactory;

public class GildedRose {
    public static final int UPPER_BOUND_QUALITY = 50;
    public static final int LOWER_BOUND_QUALITY = 0;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void tick() {
        ItemTickDecorator[] itemTickDecorators = getItemTickDecorators();
        for (ItemTickDecorator itemTickDecorator : itemTickDecorators){
            itemTickDecorator.tick();
        }
    }

    private ItemTickDecorator[] getItemTickDecorators(){
        ItemTickDecorator[] itemTickDecorators = new ItemTickDecorator[items.length];
        for(int i = 0; i < items.length; i++){
            itemTickDecorators[i] = ItemTickDecoratorFactory.createItemTickDecorator(items[i]);
        }
        return itemTickDecorators;
    }
}
