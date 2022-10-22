import org.etsntesla.it.dodaci.Putnik;
import org.etsntesla.it.vozila.Vozilo;
import org.junit.jupiter.api.*;


@Disabled
public class VoziloTest2 {


    static double[] vreme = {2,2,2,20,10,20,10,100};

    static int testIndex = 0;

    //static ApplicationContext ctx;

    //snaga=50, sed=4, snagaAlter=5
    static Vozilo auto1;
    static Vozilo auto2;
    static Putnik putnik1,putnik2;


    @BeforeAll
    static void init(){

        //ctx = new ClassPathXmlApplicationContext("beans.xml");

        //auto = new Vozilo(50.0d,4);
        //auto1 = (Vozilo) ctx.getBean("vozilo1");
        //auto2 = (Vozilo) ctx.getBean("vozilo2");
        //instance putnik1, putnik2 su instance anonimnih klasa koje implementriaju interfejs Putnik
        putnik1 = new Putnik() {
            @Override
            public boolean startovanjeVozila() {
                return true;
            }
        };
        putnik2 = new Putnik() {
            @Override
            public boolean startovanjeVozila() {
                return true;
            }
        };

        auto1.putnici = new Putnik[4];
        auto2.putnici = new Putnik[4];
        putnik1.ulazakUVozilo(auto1,0);
        putnik2.ulazakUVozilo(auto2,0);
    }

    @BeforeEach
    void separator(){
        System.out.println("\nTEST"+(testIndex+1)+"\n");
    }

    @AfterEach
    void loggingAfter(){
        granicnik("Auto1");
        System.out.println("Info: "+auto1.toString()+"\n"+auto1.stanjeMotora());
        System.out.println();
        granicnik("Auto2");
        System.out.println("Info: "+auto2.toString()+"\n"+auto2.stanjeMotora());
        testIndex++;
    }


    @Test
    void test1(){
        auto1.start();
        auto1.voznja(vreme[testIndex]);
    }

    @Test
    void test2(){
        auto2.start();
        auto2.voznja(vreme[testIndex]);
    }


    private void granicnik(String naslov){
        String ispis = "********************"+naslov+"********************";
        System.out.println(ispis);

    }

}
