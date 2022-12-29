package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{0,0,0,0},0));
    }

    public static int subarraySum(int[] nums, int k) {
        if(nums.length==1){
            return nums[0] == k ? 1 : 0;
        }
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            result += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
