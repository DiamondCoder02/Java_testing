import jarmu.szarazfoldi.auto;
import jarmu.szarazfoldi.motor;
import jarmu.szarazfoldi.szarazfoldijarmu;
import jarmu.szinek;
import jarmu.vizi.Yacht;

public class Application {
    public static void main(String[] args){
        auto auto1 = new auto(szinek.kek);
        szarazfoldijarmu motor = new motor(szinek.sarga);
        motor.color = szinek.sarga;
        Yacht hajo = new Yacht(szinek.zold);

        System.out.println(auto1.color.getErtek());
        System.out.println(motor.color);

        System.out.println("Az autonak " + auto1.kerekekszama + " kereke van");

        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        auto1.elindul(20);
        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        auto1.gyorsit(400);
        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        auto1.megall();
        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        System.out.println();


        System.out.println("Ennyivel megy a motor: " + motor.getSebesseg());
        motor.elindul();
        System.out.println("Ennyivel megy a motor: " + motor.getSebesseg());
        motor.megall();
        System.out.println("Ennyivel megy a motor: " + motor.getSebesseg());


        System.out.println();
        System.out.println("A hajo sebessege: " + hajo.getSebesseg());
        hajo.elindul();
        System.out.println("A hajo indulasi sebessege: " + hajo.getSebesseg());
        hajo.gyorsit(150);
        System.out.println("A hajo gyorsitot: " + hajo.getSebesseg());
        hajo.megall();
        System.out.println("A hajo megallt,a sebessege: " +hajo.getSebesseg());
    }
}