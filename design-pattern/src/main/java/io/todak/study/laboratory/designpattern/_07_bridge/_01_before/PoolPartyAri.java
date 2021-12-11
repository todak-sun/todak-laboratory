package io.todak.study.laboratory.designpattern._07_bridge._01_before;

class PoolPartyAri implements Champion {


    @Override
    public void move() {
        System.out.println("PoolParty Ari move");
    }

    @Override
    public void skillQ() {
        System.out.println("PoolParty Ari Q");
    }

    @Override
    public void skillW() {
        System.out.println("PoolParty Ari W");
    }

    @Override
    public void skillE() {
        System.out.println("PoolParty Ari E");
    }

    @Override
    public void skillR() {
        System.out.println("PoolParty Ari R");
    }
}
