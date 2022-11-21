package easy;

import java.util.Arrays;

//https://leetcode.com/problems/remove-element/
public class RemoveElementArray {
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,5};
        System.out.println(removeElement(arr, 3));
        System.out.println(Arrays.toString(arr));

    }

    public static int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            if(nums[right] == val){
                right--;
                continue;
            }
            if(nums[left] == val){
                nums[left] = nums[right];
                nums[right] = val;
                left++;
                right--;
                continue;
            }
            left++;
        }
        return left;
    }
}
