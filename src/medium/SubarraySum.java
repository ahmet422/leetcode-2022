package medium;
// https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1,-1,1},0));
    }

    public static int subarraySum(int[] nums, int k) {
        if(nums.length==1){
            return nums[0] == k ? 1 : 0;
        }
        int count=0;
        int sum = 0;
        int l = 0, r = 0;
        sum = sum + nums[l];
        while(r < nums.length){
            if(sum == k) {
                count++;
                r++;
                if(r>= nums.length) return count;
                sum = sum + nums[r];
            }
            else if(sum > k) {
                sum = sum - nums[l];
                l++;
            }else if(sum < k){
                r++;
                if(r>= nums.length) return count;
                sum = sum + nums[r];
            }
        }

        return count;
    }
}
