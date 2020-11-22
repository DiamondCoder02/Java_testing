
import java.util.Scanner;

public class Application {

    public static void main(String[]args) {
        System.out.println("Test1");
        Scanner scanner = new Scanner(System.in);

        System.out.println("First sentence");
        String sentence = scanner.nextLine();

        String word = sentence;
        String[] part = word.split(" ");

        String long1 = "";
        for (int i = 0 ; i < part.length; i++ ){
            int mennyiseg = part[i].length();
            int lfw = long1.length();
            if (mennyiseg >= lfw) {
                long1 = part[i];
            }
        }
        System.out.println(long1);

    }
}
