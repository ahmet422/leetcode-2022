package easy;

import java.util.*;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k+1);
        for (int n : nums) {
            pq.add(n);
        }
        this.k = k;
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
