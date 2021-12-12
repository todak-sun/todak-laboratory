package io.todak.study.laboratory.designpattern._08_composite._02_after;

import java.util.ArrayList;
import java.util.List;

class Bag implements Component {

    private List<Component> items = new ArrayList<>();

    public void add(Component item) {
        this.items.add(item);
    }

    @Override
    public int getPrice() {
        return this.items.stream().mapToInt(Component::getPrice).sum();
    }
}
