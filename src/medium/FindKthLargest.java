package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int n : nums){
            if(pq.size()==k){
                if(n > pq.peek()){
                    pq.poll();
                    pq.add(n);
                    continue;
                }
            }else{
                pq.add(n);
            }
        }
        return pq.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k+1];
    }
}
