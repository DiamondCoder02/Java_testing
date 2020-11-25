package decorator;

import adapter.Auto;
import adapter.AutoMoso;

public class AutoMosoSzarito {
    public AutoMoso autoMoso;

    public AutoMosoSzarito(AutoMoso autoMoso){
        this.autoMoso = autoMoso;
    }

    public void mosEsSzarít(Auto auto) {
        autoMoso.mos(auto);
        System.out.println("Megszárítottam az autót");
    }
}
