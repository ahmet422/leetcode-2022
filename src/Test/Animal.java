package Test;

public class Animal implements Protects {
    private String namePrivate;
    protected String nameProtected;
    public String namePublic;
    String nameDefault;

    public String getNamePrivate() {
        return namePrivate;
    }

    @Override
    public void protect() {
        System.out.println("I will protect you!!!");
    }
}
