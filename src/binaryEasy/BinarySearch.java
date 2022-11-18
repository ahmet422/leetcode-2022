package binaryEasy;

import java.util.Arrays;

// https://leetcode.com/problems/binary-search/
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search2(new int[]{-3,0,3,5,9,12,45}, 5));
    }

    public static int search(int[] nums, int target) {
        int left, right, mid;
        left=0; right = nums.length-1; mid = (right+left)/2;
        while(left<=right){
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
            mid = (left+right)/2;
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int left, right, mid;
        left=0; right = nums.length-1;
        return searchRecursive(nums,target,left,right);
    }

    public static int searchRecursive(int[] nums, int target, int l, int r) {
        if(l>r){
            return  -1;
        }
        int mid = (l+r)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            l = mid+1;
            return searchRecursive(nums,target,l,r);
        }else{
            r = mid - 1;
            return searchRecursive(nums,target,l,r);
        }
    }
}
