package Test;

public class Dog extends Animal {
    int breed;

    @Override
    public void protect() {
        System.out.println("Dog protection!");
    }
}
