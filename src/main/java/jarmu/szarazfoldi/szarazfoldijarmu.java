package jarmu.szarazfoldi;

import jarmu.jarmu;

public abstract class szarazfoldijarmu implements jarmu {
    public String color;
    public Integer sebesseg = 0;
    public Integer kerekekszama;

    public abstract void gyorsit(Integer mertek);

    @Override
    public void megall() {
        sebesseg = 0;
    }
}
