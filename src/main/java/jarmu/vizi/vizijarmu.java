package jarmu.vizi;

import jarmu.szinek;

public abstract class vizijarmu extends sarmu {
    public static final int Alapsebesseg = 100;

    public szinek color;
    protected Integer sebesseg = 0;
    public Integer vitorlakszama;

    public final void elindul(){sebesseg = Alapsebesseg;}

    public abstract void gyorsit(Integer mertek);

    @Override
    public void megall(){ sebesseg = 0;}
    public Integer getSebesseg(){return sebesseg;}
}
