package easy;

import java.util.Arrays;

// link: https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] sArr = new String[]{"ciar", "cir","ciarra", "ciyomayo"};
        System.out.println(longestCommonPrefix(sArr));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs,(a,b) -> Integer.compare(a.length(),b.length()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++){
            char chTemp = strs[0].charAt(i);
            boolean notInPrefix = false;
            for (String s: strs) {
                if(chTemp != s.charAt(i)){
                    notInPrefix = true;
                    break;
                }
            }
            if(!notInPrefix){
                sb.append(chTemp);
            }else {
                break;
            }
        }
        return sb.toString();
    }

    public static String longestCommonPrefixEfficient(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
