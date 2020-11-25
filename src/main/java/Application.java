import adapter.Auto;
import adapter.AutoMoso;
import adapter.AutoMosoAdapter;
import adapter.Kocsi;
import builder.Dobokocka;
import builder.KockaBuilder;
import decorator.AutoMosoSzarito;

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

        Kocsi kocsi = new Kocsi("Ferearri");
        AutoMosoAdapter autoMosoAdapter = new AutoMosoAdapter(new AutoMoso());
        AutoMosoAdapter.mos(kocsi);

        AutoMosoSzarito autoMosoSzarito = new AutoMosoSzarito(new AutoMoso());
        autoMosoSzarito.mosEsSzarít(new Auto("Toyota"));
    }
}