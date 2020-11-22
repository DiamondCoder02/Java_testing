public class auto {
    public String color;
    public Integer sebesseg = 0;

    public auto(String color){
        this.color = color;
    }

    public void elindulni(){
        System.out.println("Az autó elindul");
        sebesseg = 50;
    }
}
