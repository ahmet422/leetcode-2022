package easy;

import java.util.Arrays;

public class MinimumDifference {
    public static void main(String[] args) {

    }

    public static int minimumDifference(int[] nums, int k) {
        if(nums.length ==1) return 0;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;

        for(int i=0;i<=nums.length-k;i++){
            min=Math.min(min,nums[i+k-1]-nums[i]);
        }
        return min;
    }
}
