package observer;

public class Figyelo implements Observer{
    @Override
    public void observe(Subject subject) {
        System.out.println(subject + " állapot megváltozott. Az új állapot: " + subject.getAllapot());
    }
}
