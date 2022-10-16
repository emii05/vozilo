package org.etsntesla.it.autodelovi;

public class Motor {

    protected boolean upaljen;
    protected boolean ispravnost;
    protected double snaga;
    protected Alternator alternator;
    protected Akumulator  akumulator;

    {
        upaljen=false;
        ispravnost=true;
        akumulator =new Akumulator();
    }

    public Motor(double snaga) {
        if(snaga>200.0d)
            this.snaga=200.0d;
        else
            this.snaga=Math.max(snaga,50.0d);

        this.alternator = new Alternator(this.snaga/10);
    }

    public boolean isUpaljen() {
        return upaljen;
    }

    public void setUpaljen(boolean upaljen) {
        if(!upaljen)
            this.upaljen = false;
        else
            if(!akumulator.getStanje().equals("PRAZAN") && ispravnost) {
                akumulator.praznjenje();
                this.upaljen = true;
            } else
                this.upaljen = false;

    }

    public boolean isIspravnost() {
        return ispravnost;
    }

    public void setIspravnost(boolean ispravnost) {
        this.ispravnost = ispravnost;
    }

    public double getSnaga() {
        return snaga;
    }

    public Alternator getAlternator() {
        return alternator;
    }

    public Akumulator getAkumulator() {
        return akumulator;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "upaljen=" + upaljen +
                ", ispravnost=" + ispravnost +
                ", snaga=" + snaga +
                ", alternator=" + alternator +
                ", akumulator=" + akumulator +
                '}';
    }

    public boolean zameniAkumulator(){
        if(!upaljen) akumulator = new Akumulator();
        return !upaljen;
    }

}

