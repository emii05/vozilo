package org.etsntesla.it.autodelovi;

import org.springframework.stereotype.Component;

@Component
public class Akumulator {

    private final static String[] NIVO_POPUNJENOSTI= {"PRAZAN","SKOROPRAZAN","POLUPRAZAN","SKOROPUN","PUN"};

    private Akumulator(){}

    private int stanje = 4;

    public String getStanje(){
        return NIVO_POPUNJENOSTI[stanje];
    }

    public void praznjenje() {
        if(stanje>0) stanje--;
    }

    public void punjenje() {
        if(stanje<4) stanje++;
    }

    @Override
    public String toString() {
        return "Stanje: "+getStanje()+"\n"+NIVO_POPUNJENOSTI.toString();
    }

    public static Akumulator akumulatorBeanFactory(){
        return new Akumulator();
    }
}
