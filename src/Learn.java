import java.util.*;

public class Learn {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);

        pq.add(3);
        pq.add(3);
        pq.add(5);
        if(pq.size()>=3){
            pq.poll();
        }
        pq.add(6);
        System.out.println(pq);
    }
}
