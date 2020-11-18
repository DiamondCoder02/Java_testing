import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    //calculator
        System.out.println("Első szám:");
        Integer szam1 = scanner.nextInt();

        System.out.println("operáció:");
        String operacio = new Scanner(System.in).nextLine();

        System.out.println("Második szám:");
        Integer szam2 = scanner.nextInt();

        System.out.println("Ezt a műveletet fogjuk elvégezni: " + szam1 + " " + operacio + " " + szam2);

        Double eredmeny = null;
        if("+".equals(operacio)){
            eredmeny = (double) szam1 + szam2;
        } else if("-".equals(operacio)){
            eredmeny = (double) szam1 - szam2;
        } else if("*".equals(operacio)){
            eredmeny = (double) szam1 * szam2;
        } else if("/".equals(operacio)){
            eredmeny = (double) szam1 / szam2;
        } else{
            System.out.println("\nIsmeretlen operandus" + operacio);
        }
        System.out.println("Ez az eredmény:" + eredmeny);

    //Bigger or smaller number
        if(szam1 < 0 && szam2 < 0){
            System.out.println("Mindkét szám kissebb mint nulla");
        }
        if(szam1 < 0 || szam2 < 0){
            System.out.println("Az eggyik szám kissebb mint nulla");
        }

        if(eredmeny <= 0){
            System.out.println("Ez egy negatív szám!!!");
        } else{
            System.out.println("Ez egy pozitív szám!!!");
        }
    //why?
        if(eredmeny == 0){
            System.out.println("Komolyan? STUPID");
        }
    //True or false
        if(igaz() && hamis()){
            System.out.println("Nem szabadna kiíródnia");
        }
        if(igaz() & hamis()){
            System.out.println("Nem szabadna kiíródnia");
        }
        if(igaz() || hamis()){
            System.out.println("Nem szabadna kiíródnia");
        }
        if(igaz() | hamis()) {
            System.out.println("Nem szabadna kiíródnia");
        }
    }
    private static  boolean igaz(){
        System.out.println("igaz");
        return true;
    }

    private static  boolean hamis(){
        System.out.println("hamis");
        return false;
    }
}