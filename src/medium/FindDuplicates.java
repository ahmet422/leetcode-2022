package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println(findDuplicatesE(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<>();
        if(nums.length==1){
            return l;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                l.add(nums[i]);
                i++;
            }
        }
        return l;
    }
    public static List<Integer> findDuplicatesE(int[] nums){
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int temp = Math.abs(nums[i]) - 1;
            if(nums[temp]<0) l.add(Math.abs(nums[i]));
            nums[temp] *= -1;
        }
        return l;
    }
}
