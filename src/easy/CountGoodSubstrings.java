package easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
public class CountGoodSubstrings {
    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("ahb"));
    }

    public static int countGoodSubstrings(String s) {
        if(s.length() < 3) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while(j-i < 3 && j < s.length()){
                if(set.add(s.charAt(j))){
                    if(j-i+1 == 3){
                        count++;
                        set.clear();
                        break;
                    }
                    j++;
                }else{
                    set.clear();
                    break;
                }
            }
        }

        return count;
    }

    public static int countGoodSubstringsEfficient(String s) {
        if(s.length() < 3) return 0;
        char a=s.charAt(0),b=s.charAt(1),c=s.charAt(2);
        int res=0;
        for(int i=3;i<=s.length()-1;i++)
        {
            if(a!=b && b!=c && c!=a) res++;
            a=b;
            b=c;
            c=s.charAt(i);
        }
        if(a!=b && b!=c && c!=a)res++;
        return res;
    }
}
