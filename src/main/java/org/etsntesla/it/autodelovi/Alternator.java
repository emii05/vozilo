package org.etsntesla.it.autodelovi;

public class Alternator {

    protected double snaga;

    public Alternator(double snaga) {
        this.snaga = snaga;
    }

    public Alternator(){}

    public double isporucenaElEnergija(double time){
        return snaga*time;
    }

    @Override
    public String toString() {
        return "Alternator{" +
                "snaga=" + snaga +
                '}';
    }

    public void setSnaga(double snaga) {
        this.snaga = snaga;
    }
}
