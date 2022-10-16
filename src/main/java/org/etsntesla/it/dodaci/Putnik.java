package org.etsntesla.it.dodaci;
import org.etsntesla.it.vozila.Vozilo;

public interface Putnik {

    default boolean startovanjeVozila(){ return false;}

    default  boolean  ulazakUVozilo(Vozilo vozilo, int mesto){
        if(vozilo.putnici[mesto] == null) {
            vozilo.putnici[mesto] = this;
            return true;
        }
        return false;
    }

    default boolean izlazakUVozilo(Vozilo vozilo,int mesto){
        if(vozilo.putnici[mesto].equals(this)){
            vozilo.putnici[mesto]=null;
            return true;
        }
        return false;
    }

}
