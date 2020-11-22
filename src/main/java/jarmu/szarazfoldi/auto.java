package jarmu.szarazfoldi;

public class auto extends szarazfoldijarmu{
    public auto(szinek color){
        this.color = color;
        this.kerekekszama = 4;
    }

    @Override
    public void elindulni() {
        sebesseg = 50;
    }

    public void elindulni(Integer mertek){
        sebesseg = mertek;
    }

    public void elindulni(short mertek){
        sebesseg = (int) mertek;
    }

    @Override
    public void gyorsit(Integer mertek) {
        sebesseg += mertek;
    }
}