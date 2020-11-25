package builder;

public class KockaBuilder {
    private Integer elsoOldal;
    private Integer masodikOldal;
    private Integer harmadikOldal;
    private Integer negyedikOldal;
    private Integer otodikOldal;
    private Integer hatodikOldal;

    public KockaBuilder(){

    }

    public KockaBuilder elsoOldal(Integer oldal){
        elsoOldal = oldal;
        return this;
    }public KockaBuilder masodikOldal(Integer oldal){
        elsoOldal = oldal;
        return this;
    }public KockaBuilder harmadikOldal(Integer oldal){
        elsoOldal = oldal;
        return this;
    }public KockaBuilder negyedikOldal(Integer oldal){
        elsoOldal = oldal;
        return this;
    }public KockaBuilder otodikOldal(Integer oldal){
        elsoOldal = oldal;
        return this;
    }public KockaBuilder hatodikOldal(Integer oldal){
        elsoOldal = oldal;
        return this;
    }

    public Dobokocka build() {
        return new Dobokocka(elsoOldal,masodikOldal,harmadikOldal,negyedikOldal,otodikOldal,hatodikOldal);
    }
}
