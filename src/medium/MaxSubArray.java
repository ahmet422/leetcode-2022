package medium;

public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }

    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum = Math.max(sum, tempSum);
                tempSum+=nums[j];
            }
            sum = Math.max(sum, tempSum);
        }
        return sum;
    }
}
