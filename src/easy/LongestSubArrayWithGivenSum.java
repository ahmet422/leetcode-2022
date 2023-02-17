package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(longestSub(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));;
    }

    public static int longestSub(int[] arr, int k){
        int prefix = 0;
        int subLength = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];
            if(prefix==k) subLength = i+1;
            if(!map.containsKey(prefix)) map.put(prefix,i);
            if (map.containsKey(prefix-k)) subLength = Math.max(subLength, i-map.get(prefix-k));
        }
        return subLength;
    }
}
