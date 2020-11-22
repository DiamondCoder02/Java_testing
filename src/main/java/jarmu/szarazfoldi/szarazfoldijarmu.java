package jarmu.szarazfoldi;

import jarmu.jarmu;

public abstract class szarazfoldijarmu implements jarmu {
    public szinek color;
    protected Integer sebesseg = 0;
    public Integer kerekekszama;

    public abstract void gyorsit(Integer mertek);

    @Override
    public void megall() {
        sebesseg = 0;
    }

    public Integer getSebesseg(){
        return sebesseg;
    }
}
