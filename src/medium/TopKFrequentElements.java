package medium;

import java.util.*;

 class MyObject implements Comparable<MyObject>{
    public  Integer value;
    public  Integer amount;

    MyObject(int value, int amount){
        this.value = value;
        this.amount = amount;
    }
     @Override
     public int compareTo(MyObject o) {
         return this.amount.compareTo(o.amount);
     }
 }

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n: nums) {
            if(!map.containsKey(n)){
                map.put(n,1);
            }else{
               map.put(n,map.get(n)+1);
            }
        }
        List<MyObject> mList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            mList.add(new MyObject(entry.getKey(), entry.getValue()));
        }
        Collections.sort(mList,Collections.reverseOrder());
        int[] numsArr = new int[k];
        for(int i = 0; i < k; i++){
            numsArr[i] = mList.get(i).value;
        }
        return numsArr;
    }
}
