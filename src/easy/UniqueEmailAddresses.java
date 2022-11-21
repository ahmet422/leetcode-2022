package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmailAddresses {
    public static void main(String[] args) {

        System.out.println(numUniqueEmails3(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));

    }
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String el: emails) {
            String[] temp = el.split("@");
            temp[0] = temp[0].concat("@");
            // remove + portion
            StringBuilder sb = new StringBuilder(temp[0]);
            if(sb.indexOf("+") != -1){
                temp[0] = sb.delete(sb.indexOf("+"), sb.indexOf("@")).toString();
            }
            // remove dots from local
            temp[0] = temp[0].replaceAll("\\.","");
            System.out.println(temp[0]+temp[1]);
            set.add(temp[0].concat(temp[1]));
        }
        return set.size();
    }

    public static int numUniqueEmails2(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String el: emails) {
            String [] sArr = el.split("@");
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(i<sArr[0].length()){
                if(el.charAt(i) == '.'){
                    i++;
                    continue;
                }else if(el.charAt(i) == '+'){
                    break;
                }
                sb.append(el.charAt(i));
                i++;
            }
            set.add(sb.toString()+"@"+sArr[1]);
        }
        return set.size();
    }

    public static int numUniqueEmails3(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String el: emails) {
            String [] sArr = el.split("@");
            String [] local = sArr[0].split("\\+");
            set.add(local[0].replaceAll("\\.","") + "@" + sArr[1]);
        }
        return set.size();
    }
}
