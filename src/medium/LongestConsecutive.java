package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/solution/
public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int longestCons = 0;
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]-1 == nums[i-1]){
                temp++;
            }else{
                longestCons = Math.max(longestCons,temp);
                temp = 0;
            }
        }
        longestCons = Math.max(longestCons,temp);
        return longestCons+1;
    }
}
