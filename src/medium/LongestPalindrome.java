package medium;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println( "abadaba".substring(0,7));
    }
    public static String longestPalindrome(String s) {

        String pali = s.charAt(s.length()-1)+"";;
        for (int i = 0; i < s.length(); i++){


            for (int j = i+1; j < s.length(); j++){
                if(pali.length()>j+1-i) break;
                if(pali.length() < (j-i) && isPlaindrome(s.substring(i,j+1))){
                    pali = s.substring(i,j+1);
                }
            }
        }
        return pali;
    }

    private static boolean isPlaindrome(String substring) {
        int l = 0, r = substring.length()-1;
        while(l<r){
            if(substring.charAt(l) != substring.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }

}
