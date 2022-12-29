package medium;

public class MinSubArray {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(7, new int[] {2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        if(nums.length == 0) return 0;

        int minimal = Integer.MAX_VALUE;

        int l=0, r= 0;
        int sum = nums[l];
        while(l < nums.length && r< nums.length){
            if(sum>=target){
                minimal = Math.min(minimal,r-l+1);
                sum = sum - nums[l];
                l++;
            }else if(sum < target){
                r++;
                if(r >= nums.length) break;
                sum = sum + nums[r];
            }
        }
        return minimal == Integer.MAX_VALUE ? 0 : minimal;
    }

    public static int minSubArrayLen2(int target, int[] nums) {

        if(nums.length == 0) return 0;

        int minimal = Integer.MAX_VALUE;

        int start=0;
        int sum =0;
        for(int end = 0; end < nums.length; end++){
            sum = sum + nums[end];

            while(sum>=target){
                minimal = Math.min(minimal, end-start+1);
                sum = sum - nums[start];
                start++;
            }
        }
        return minimal == Integer.MAX_VALUE ? 0 : minimal;
    }



}
