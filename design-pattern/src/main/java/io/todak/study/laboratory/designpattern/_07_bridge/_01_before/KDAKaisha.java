package io.todak.study.laboratory.designpattern._07_bridge._01_before;

class KDAKaisha implements Champion {
    @Override
    public void move() {
        System.out.println("KDA Kaisha move");
    }

    @Override
    public void skillQ() {
        System.out.println("KDA Kaisha Q");
    }

    @Override
    public void skillW() {
        System.out.println("KDA Kaisha W");
    }

    @Override
    public void skillE() {
        System.out.println("KDA Kaisha E");
    }

    @Override
    public void skillR() {
        System.out.println("KDA Kaisha R");
    }
}
