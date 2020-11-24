package jarmu.szarazfoldi;

import jarmu.szinek;

public class motor extends szarazfoldijarmu{
    public motor(szinek color){
        this.color = color;
        this.kerekekszama = 2;
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
