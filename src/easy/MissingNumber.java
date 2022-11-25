package easy;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public static void main(String[] args) {

    }

    public static  int missingNumber(int[] nums) {
        int sum=0;
        for (int n: nums) {
            sum+=n;
        }
        return (nums.length*nums.length-1)- sum;
    }
}
