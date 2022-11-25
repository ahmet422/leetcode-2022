package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,7,2,3,7}));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        int number = 1;
       for(int i = 0; i < nums.length; i++){
           if(nums[i] == number){
               number++;
           } else if(nums[i] > number){
               while(number < nums[i]){
                   l.add(number);
                   number++;
               }
               number++;
           }
       }

       while(number<=nums.length){
           l.add(number);
           number++;
       }
        return l;
    }

    public static List<Integer> findDisappearedNumbersEfficient(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}

