package jarmu.vizi;

public enum szinek {
    zold("zöld"),
    kek("kék"),
    sarga("sárga");

    szinek(String ertek) {
        this.ertek = ertek;
    }

    public final String ertek;
}
