package io.todak.study.laboratory.designpattern._08_composite._01_before;

class Item {

    private String name;
    private int price;


    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
