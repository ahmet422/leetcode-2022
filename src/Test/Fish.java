package Test;

public class Fish extends Animal {

    @Override
    public String getNamePrivate() {
        return super.getNamePrivate();
    }

    @Override
    public void protect() {
        System.out.println("Fish protection!!!");
    }
}
