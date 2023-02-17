package Test;

import easy.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fish f1 = new Fish();
        Dog d1 = new Dog();
        d1.breed = 5;
        Animal a1 = new Animal();


        System.out.println(f1.getNamePrivate());
        ArrayList<Animal> list = new ArrayList<>();
        list.add(a1);
        list.add(f1);
        list.add(d1);

//        for (Animal a : list) {
//            if(a instanceof Dog){
//                System.out.println(((Dog) a).breed);
//            }
//        }

        Protects p = new Fish();
        p.protect();

        System.out.println(list);
    }
}
