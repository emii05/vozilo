package org.etsntesla.it;

import org.etsntesla.it.autodelovi.Akumulator;
import org.etsntesla.it.autodelovi.Alternator;
import org.etsntesla.it.autodelovi.Motor;
import org.etsntesla.it.vozila.Vozilo;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory implements ApplicationContextAware {

    ApplicationContext ctx;

    boolean jaciMotor=true;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
            ctx= applicationContext;
    }

    @Bean
    public  Motor motorBeanFactory(){
        Motor motor = new Motor();
        motor.setSnaga(50);
        motor.setAkumulator(ctx.getBean(Akumulator.class));
        motor.setAlternator(ctx.getBean(Alternator.class));
        return motor;
    }

    public Vozilo voziloXBeanFactory(){
        jaciMotor =! jaciMotor;
        if(jaciMotor)
            return (Vozilo) ctx.getBean("vozilo2");
        else
            return (Vozilo) ctx.getBean("vozilo1");
    }

    @Bean
    public Alternator alternator5(){
        Alternator alternator=new Alternator();
        alternator.setSnaga(5);
        return alternator;
    }
}
