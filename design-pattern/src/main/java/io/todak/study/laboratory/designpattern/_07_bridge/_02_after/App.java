package io.todak.study.laboratory.designpattern._07_bridge._02_after;

public class App {

    public static void main(String[] args) {
        Champion kda = new Ari(new KDA());
        kda.skillQ();
        kda.skillW();

        Champion poolPartyAri = new Ari(new PoolParty());
        poolPartyAri.skillR();
        poolPartyAri.skillW();
    }

}
