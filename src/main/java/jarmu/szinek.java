package jarmu;

import jarmu.jarmu;

public enum szinek {
    zold("zöld"),
    kek("kék"),
    sarga("sárga");

    szinek(String ertek){
        this.ertek = ertek;
    }

    private final String ertek;

    public String getErtek(){
        return  ertek;
    }
}
