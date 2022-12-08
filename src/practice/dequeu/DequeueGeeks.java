package practice.dequeu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DequeueGeeks {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        System.out.println(dq.pollFirst());
        try {
            System.out.println(dq.removeFirst());
        }catch (NoSuchElementException ex){
            System.out.println(ex.toString());
        }

        System.out.println(dq);

        dq.offerFirst(10);
        System.out.println(dq);

        dq.offerLast(22);
        System.out.println(dq);

        dq.push(55);
        System.out.println(dq);


        for (int el:dq){
            System.out.println(el);
        }

        ArrayDeque<Integer> adq = new ArrayDeque<>();


    }
}
