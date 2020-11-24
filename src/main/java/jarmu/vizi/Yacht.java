package jarmu.vizi;

import jarmu.szinek;

public class Yacht extends vizijarmu{
    public Integer sebesseg = 0;

    public Yacht(szinek color){
        this.color = color;
        this.vitorlakszama = 1;
    }

    public void elindul(Integer mertek){sebesseg = mertek;}

    @Override
    public void gyorsit(Integer mertek) {
        super.sebesseg += mertek;
    }
}

