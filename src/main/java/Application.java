import builder.Dobokocka;
import builder.KockaBuilder;

public class Application {
    public static void main(String[] args) {
        Dobokocka kocka = new KockaBuilder()
                .elsoOldal(2)
                .masodikOldal(4)
                .harmadikOldal(8)
                .negyedikOldal(16)
                .otodikOldal(32)
                .hatodikOldal(64)
                .build();
        System.out.println(kocka);
    }
}