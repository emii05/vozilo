package org.etsntesla.it.vozila;

import org.etsntesla.it.autodelovi.Motor;
import org.etsntesla.it.dodaci.AutoMehanicar;
import org.etsntesla.it.dodaci.Putnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vozilo1")
public class Vozilo {

    private static int nextSerialID=1000;

    protected int serialID;

    @Autowired
    @Qualifier("motorBeanFactory")
    protected Motor motor;
    protected double kilometraza;
    public Putnik[] putnici;

    public Vozilo(double snaga, int brojSedista){
        serialID = nextSerialID++;
        kilometraza=0.0d;
        motor = new Motor(snaga);
        putnici =new Putnik[brojSedista];
    }

    public Vozilo(){
        serialID = nextSerialID++;
        kilometraza=0.00;
        putnici = new Putnik[4];


    }

    public void start(){
        if(putnici[0]!=null && putnici[0].startovanjeVozila()){
            motor.setUpaljen(true);
        }
    }

    public void voznja(double vreme){
        if(motor.isUpaljen() && motor.isIspravnost()){

            //da li se vozilo pokvarilo
            double pragKvara = 0.0001d*kilometraza;
            if (pragKvara>0.5d) pragKvara=0.5d;
            double pojavaKvara = Math.random();
            if(pojavaKvara<pragKvara)
                motor.setIspravnost(false);

            //da li se akumulator napunio
            if(motor.getAlternator().isporucenaElEnergija(vreme)>50.0d)
                motor.getAkumulator().punjenje();

            //kretanje i zaustavljanje
            kilometraza += motor.getSnaga()*vreme;
            motor.setUpaljen(false);
        }
    }

    public String stanjeMotora(){
        return motor.toString();
    }

    public void popravkaMotora(AutoMehanicar majstor){
        motor = majstor.popravkaMotora(motor);
        kilometraza=0.0d;
    }


    @Override
    public String toString() {
        return "Vozilo{" +
                "serialID=" + serialID +
                ", kilometraza=" + kilometraza +
                '}';
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
