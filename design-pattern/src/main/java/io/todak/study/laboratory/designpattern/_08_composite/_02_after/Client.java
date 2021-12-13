package io.todak.study.laboratory.designpattern._08_composite._02_after;

class Client {

    public static void main(String[] args) {
        Item doranBlade = new Item("도란검", 450);
        Item healPotion = new Item("체력 물약", 50);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(healPotion);

        Client client = new Client();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }

    public void printPrice(Component component) {
        System.out.println(component.getPrice());
    }


}
