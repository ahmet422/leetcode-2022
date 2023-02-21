package easy;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class ContainsDup {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{23,45,67,11};
        String[] arr2 = new String[]{"hey", "whats", "up"};
        Person p1 = new Person("Z",34);
        Person p2 = new Person("G",4);
        Person p3 = new Person("A",4);
        Person p4 = new Person("D",54);

        Person[] arr = new Person[]{p1,p2,p3,p4};

       // System.out.println(sortByName(arr));
        System.out.println(IntStream.rangeClosed(1,5).reduce(1, (left, right) -> left*right));
    }

    public static <T extends Comparable> List<T> sort (T[] arr){
        List<T> list = new ArrayList<>();
        Arrays.sort(arr);
        return Arrays.asList(arr);
    }
    public static <T extends Person> List<T> sortByName (T[] arr){
        List<T> list = new ArrayList<>();
        Arrays.sort(arr, Comparator.comparing(a -> a.name));
        return Arrays.asList(arr);
    }
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if(list.contains(num)) return true;
            list.add(num);
        }
        return false;
    }

    public static boolean isAnagram(String s, String t) {
        ArrayList<Integer> list = new ArrayList<>(26);

        for(int i = 0; i < 26; i++){
            list.add(0);
        }

        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            list.set(index, list.get(index)+1);
        }

        for(int i = 0; i < s.length(); i++){
            int index = t.charAt(i) - 'a';
            list.set(index, list.get(index)-1);
            if(list.get(index)<0) return false;
        }

        for (int num : list) {
            if(num > 0 || num < 0 ) return false;
        }
        return true;
    }

    public  List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] arr = new int[26];
            for(int j = 0; j < s.length(); j++){
                arr[s.charAt(j) - 'a']++;
            }
            String rep = Arrays.toString(arr);
            if(map.containsKey(rep)){
                map.get(rep).add(s);
            }else{
                map.put(rep,new ArrayList<>());
                map.get(rep).add(s);
            }
        }
        List<List<String>> l = new ArrayList<>(map.values());

        return l;
    }
}
