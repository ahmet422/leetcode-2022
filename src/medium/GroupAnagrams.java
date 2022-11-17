package medium;
// https://leetcode.com/problems/group-anagrams/
import java.util.*;

public class GroupAnagrams {
    private static List<List<String>> result;

    public static void main(String[] args) {
        String s = "teas";
        String t = "aets";
        char []ch = t.toCharArray();
        Arrays.sort(ch);

        System.out.println(Arrays.toString(ch));

        System.out.println(groupAnagramsEfficient2(new String[]{"eat","tea","tan","ate","nat","zen","tab"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < strs.length; i++){
            char [] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if(set.contains(Arrays.toString(chars))){
                continue;
            }
            List<String> temp = new ArrayList<>();
            boolean exist = false;
                for (int j = i+1; j < strs.length; j++){
                    if (isAnagram(strs[i], strs[j])){
                        char [] chars2 = strs[i].toCharArray();
                        Arrays.sort(chars2);
                        if(set.contains(Arrays.toString(chars2))){
                            temp.add(strs[j]);
                            continue;
                        }
                        exist = true;
                        set.add(Arrays.toString(chars2));
                        temp.add(strs[i]);
                        temp.add(strs[j]);
                    }
                }
                if(!exist) temp.add(strs[i]);
                if(!temp.isEmpty()) l.add(temp);
        }

        return l;
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char [] ch1 = s.toCharArray();
        char [] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(!Arrays.equals(ch1,ch2)){
            return false;
        }
        return true;
    }

    public static List<List<String>> groupAnagramsEfficient(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = Arrays.toString(chars);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }else{
                map.put(str,new ArrayList<>());
                map.get(str).add(s);
            }
        }
        List<List<String>> l = new ArrayList<>(map.values());

        return l;
    }

    public static List<List<String>> groupAnagramsEfficient2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        return new AbstractList<List<String>>() {

            public List<String> get(int index) {
                if (result == null)
                    init();
                return result.get(index);
            }

            public int size() {
                if (result == null)
                    init();
                return result.size();
            }

            private void init() {
                for (String s : strs) {
                    char[] count = new char[26];

                    for (char c : s.toCharArray())
                        count[c - 'a']++;
                    String key = String.valueOf(count);

                    if (!map.containsKey(key))
                        map.put(key, new ArrayList<String>());

                    map.get(key).add(s);
                }

                result = new ArrayList<>(map.values());
            }
        };
    }
}
