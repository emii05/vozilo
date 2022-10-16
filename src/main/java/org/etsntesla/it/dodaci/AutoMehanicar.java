package org.etsntesla.it.dodaci;

import org.etsntesla.it.autodelovi.Motor;

public interface AutoMehanicar {
    default Motor popravkaMotora(Motor motor) {
        motor.setIspravnost(true);
        return motor;
    }
}
