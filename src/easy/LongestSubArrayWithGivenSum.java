package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(longestSub(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0,1);
//        map.put(0,2);
//        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }

    public static int longestSub(int[] arr, int k){
        int prefix = 0;
        int subLength = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefix = prefix + arr[i];
            int diff = prefix-k;
            if(prefix==k){
                subLength = i+1;
            }
            if(!map.containsKey(prefix)){
                map.put(prefix,i);
            }
            if (map.containsKey(diff)){
                subLength = Math.max(subLength, i-map.get(diff));
            }
        }
        return subLength;
    }
}
