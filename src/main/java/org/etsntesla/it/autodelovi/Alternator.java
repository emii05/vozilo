package org.etsntesla.it.autodelovi;

public class Alternator {

    protected final double snaga;

    public Alternator(double snaga) {
        this.snaga = snaga;
    }

    public double isporucenaElEnergija(double time){
        return snaga*time;
    }

    @Override
    public String toString() {
        return "Alternator{" +
                "snaga=" + snaga +
                '}';
    }
}
