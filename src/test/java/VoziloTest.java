import org.etsntesla.it.dodaci.AutoMehanicar;
import org.etsntesla.it.dodaci.Putnik;
import org.etsntesla.it.vozila.Vozilo;
import org.junit.jupiter.api.*;

public class VoziloTest {


    // 50 < 5*vreme[i] ne puni akumulator (vreme =10)
    // 50*vreme[i] je predjena kilometraza
    // kilometraza iznad 5000 daje prag kvara 50% (vreme = 100)
    static double[] vreme = {20,10,10,20,20,10,10,100};

    static int testIndex = 0;

    //snaga=50, sed=4, snagaAlter=5
    static Vozilo auto;
    static Putnik putnik1,putnik2;
    static AutoMehanicar majstor;



    @BeforeAll
    static void init(){
        auto = new Vozilo(50.0d,4);
        //instance putnik1, putnik2 su instance anonimnih klasa koje implementriaju interfejs Putnik
        putnik1 = new Putnik() {
            @Override
            public boolean startovanjeVozila() {
                return true;
            }
        };
        putnik2 = new Putnik(){};
        majstor =new AutoMehanicar(){};
        putnik1.ulazakUVozilo(auto,0);
        putnik2.ulazakUVozilo(auto,1);
    }

    @BeforeEach
    void loggingBefore(){
        for(Putnik p:auto.putnici)
            System.out.println("   "+p);
    }

    @AfterEach
    void loggingAfter(){
        System.out.println("Auto info: "+auto.toString()+"\n"+auto.stanjeMotora());
        testIndex++;
    }


    @Test
    void test1(){
        putnik1.ulazakUVozilo(auto,0);
        putnik2.ulazakUVozilo(auto,1);
        auto.start();
        auto.voznja(vreme[testIndex]);
    }

    @Test
    void test2(){
        putnik1.izlazakUVozilo(auto,0);
        auto.start();
        auto.voznja(vreme[testIndex]);
    }

    @RepeatedTest(3)
    @DisplayName("test3")
    void test3(){
        putnik1.ulazakUVozilo(auto,0);
        auto.start();
        auto.voznja(vreme[testIndex]);
    }


}
