package proxy;

import adapter.Auto;
import adapter.AutoMoso;

public class AutoMosoProxy {
    private AutoMoso autoMoso = null;
    private Integer mososzerMennyiség = 0;

    public void mos(Auto auto){
        if (autoMoso == null) {
            System.out.println("Nincs automosó, vegyünk eggyet!");
            autoMoso = new AutoMoso();
        }

        if (mososzerMennyiség == 0) {
            utantolt();
        }
        autoMoso.mos(auto);

        mososzerMennyiség--;
        System.out.println("Mosás kész. " + mososzerMennyiség + "mosószer maradt.");
    }

    private void utantolt() {
        System.out.println("Utántöltés...");
        mososzerMennyiség = 5;
    }
}
