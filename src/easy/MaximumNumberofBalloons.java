package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// https://leetcode.com/problems/maximum-number-of-balloons/
public class MaximumNumberofBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("leetcode"));
    }

    public static int maxNumberOfBalloons(String text) {
        if(!text.contains("b") || !text.contains("a")
                || !text.contains("l")
                || !text.contains("o")
                || !text.contains("n")){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++){
            boolean exists = text.charAt(i)=='b' || text.charAt(i)=='a' ||text.charAt(i)=='l' ||text.charAt(i)=='o' ||text.charAt(i)=='n';

            if(exists){
                if(map.containsKey(text.charAt(i))){
                   map.put(text.charAt(i), map.get(text.charAt(i))+1);
                }else{
                    map.put(text.charAt(i),1);
                }
            }
        }

        map.put('l', map.get('l')/2);
        map.put('o', map.get('o')/2);

        int minValue = map.values().stream().min(Integer::compare).get();

        return minValue;
    }

    public static int maxNumberOfBalloonsEfficient(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for(char ch : text.toCharArray()){
            switch(ch){
                case 'b': ++b;
                    break;
                case 'a': ++a;
                    break;
                case 'l': ++l;
                    break;
                case 'o': ++o;
                    break;
                case 'n': ++n;
                    break;

            }
        }

        l=l/2;
        o=o/2;
        int min = b;
        min = Math.min(min, a);
        min = Math.min(min, l);
        min = Math.min(min, o);
        min = Math.min(min, n);

        return min;
    }

}
