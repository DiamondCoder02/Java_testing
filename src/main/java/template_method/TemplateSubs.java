package template_method;

public class TemplateSubs extends Template{
    @Override
    protected void lepesElott(){
        System.out.println("Lépés elött");
    }
    @Override
    protected void lepesUtan(){
        System.out.println("Lépés után");
    }
}
