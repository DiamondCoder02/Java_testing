package jarmu.szarazfoldi;

import jarmu.jarmu;
import jarmu.szinek;

public abstract class szarazfoldijarmu implements jarmu {
    public static final int Alapsebesseg = 50;

    public szinek color;
    protected Integer sebesseg = 0;
    public Integer kerekekszama;

    public final void elindul(){
        sebesseg = Alapsebesseg;
    }

    public abstract void gyorsit(Integer mertek);

    @Override
    public void megall() {
        sebesseg = 0;
    }
    public Integer getSebesseg(){
        return sebesseg;
    }
}
