package medium;

import java.util.*;

// https://leetcode.com/problems/longest-repeating-character-replacement/
public class CharacterReplacement {
    public static void main(String[] args) {
        String address = "731 Walker Locks, Suite 292, 45444-1882, Sipesmouth, Florida, United States";
        address = address.substring(0,address.lastIndexOf(','));
        System.out.println(address); //output: 731 Walker Locks, Suite 292, 45444-1882, Sipesmouth, Florida
        address = address.substring(address.lastIndexOf(' ')+1).trim();
        System.out.println(address); //output:Florida
        // now you can use address as a state

//        String s1 = "731 Walker Locks, Suite 292, 45444-1882, Sipesmouth, Florida, United States";
//        String[] strArr = s1.split(", ");
//        System.out.println(Arrays.toString(strArr)); //output:[731 Walker Locks, Suite 292, 45444-1882, Sipesmouth, Florida, United States]
//        String state = strArr[4];
//        System.out.println(state); //output: Florida
//        // now you can use state string




      //  System.out.println(characterReplacement("ABAB",2));
    }
    public static int characterReplacement(String s, int k) {

        int rep = k;
        int size = 0;
        int max = 0;
        int res = 0;

        int l=0, r=0;
        Map<Character,Integer> map = new HashMap<>();
        map.putIfAbsent(s.charAt(r),1);
        while(r<s.length()){
        //    if(s.length()- l <= res) break;

            if(r-l+1-max<=k){
                res = Math.max(res,r-l+1);
                r++;
                if(s.length()>r){
                    if(map.containsKey(s.charAt(r))){
                        map.put(s.charAt(r),map.get(s.charAt(r))+1);
                    }else{
                        map.put(s.charAt(r),1);
                    }
                }
            }else{
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            max = Collections.max(map.values());
        }
        return res;

    }

    public int characterReplacement2(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;

    }
}
