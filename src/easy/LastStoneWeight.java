package easy;

import java.util.*;

//https://leetcode.com/problems/last-stone-weight/
public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int [] {2,7,4,1,8,1}));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int n: stones) pq.add(n);

        while(pq.size()>2){
            int st1 = pq.poll();
            int st2 = pq.poll();

            if(st1 == st2){
                continue;
            }else{
                pq.add(st1-st2);
            }
        }

        if(pq.size()==2){
            int st1 = pq.poll();
            int st2 = pq.poll();

            if(st1 == st2){
                return 0;
            }else{
                return st1-st2;
            }
        }
        return pq.peek();
    }
}
