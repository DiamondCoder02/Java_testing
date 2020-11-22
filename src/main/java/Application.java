import jarmu.szarazfoldi.auto;
import jarmu.szarazfoldi.motor;
import jarmu.szarazfoldi.szarazfoldijarmu;

public class Application {
    public static void main(String[] args) {
        szarazfoldijarmu auto1 = new auto("piros");
        szarazfoldijarmu motor = new motor();

        System.out.println(auto1.color);
        System.out.println(motor.color);

        System.out.println("Az autonak " + auto1.kerekekszama + " kereke van.");

        System.out.println("Autó1 sebessége: " + auto1.sebesseg);
        auto1.elindulni();
        System.out.println("Autó1 sebessége: " + auto1.sebesseg);
        auto1.gyorsit(20);
        System.out.println("Autó1 sebessége: " + auto1.sebesseg);
        auto1.megall();
        System.out.println("Autó1 sebessége: " + auto1.sebesseg);

        System.out.println("motor sebessége: " + motor.sebesseg);
        motor.elindulni();
        System.out.println("motor sebessége: " + motor.sebesseg);
        motor.megall();
        System.out.println("motor sebessége: " + motor.sebesseg);
    }
}
