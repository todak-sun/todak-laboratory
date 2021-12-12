package io.todak.study.laboratory.designpattern._08_composite._01_before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Bag {

    List<Item> items = new ArrayList<>();

    public void add(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }
}
