import org.etsntesla.it.vozila.Vozilo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


@Disabled
public class VoziloTest3 {

    Vozilo[] izlog = new Vozilo[4];

    @Test
    void  test1(){
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        for (int i=0;i<4;i++){
            //izlog[i]=(Vozilo) ctx.getBean("voziloX");
            granicnik("Auto"+i+1);
            System.out.println("Info: "+izlog[i].toString()+"\n"+izlog[i].stanjeMotora());
        }
    }

    private void granicnik(String naslov){
        String ispis = "********************"+naslov+"********************";
        System.out.println(ispis);

    }
}

