package jarmu.szarazfoldi;

public class motor extends szarazfoldijarmu{
    public motor(szinek color){
        this.color = color;
        this.kerekekszama = 2;
    }

    public motor() {

    }

    public void elindulni(){
        sebesseg = 70;
    }
    public void megall(){
        sebesseg = 0;
    }

    @Override
    public void gyorsit(Integer mertek) {
        sebesseg += mertek;
    }
}
