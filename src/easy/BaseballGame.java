package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// link:https://leetcode.com/problems/baseball-game/
public class BaseballGame {

    public static void main(String[] args) {
        System.out.println(calPointsEfficient2(new String[]{"5","2","C","D","+"}));
    }

    public static int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for ( String el: operations) {
            if(isNumeric(el)){
                list.add(Integer.parseInt(el));
            }else{
                //Record a new score that is the sum of the previous two scores.
                if(el.equals("+")){
                    int num1, num2, sum;
                    num1 = list.get(list.size()-1);
                    num2 = list.get(list.size()-2);
                    sum = num1+num2;
                    list.add(sum);
                }else //Record a new score that is the double of the previous score.
                    if(el.equals("D")){
                    int prev;
                    prev = list.get(list.size()-1);
                    list.add(2*prev);
                }else //Invalidate the previous score, removing it from the record.
                    {
                    list.remove(list.get(list.size()-1));
                }
            }
        }

        int sum = 0;
        for (int num : list) {
            sum = sum + num;
        }
        return sum;
    }

    public static boolean isNumeric(String string) {
        int intValue;

       // System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    public static int calPointsEfficient(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();

        for (String s: operations) {
            if(s.equals("C")){
                list.removeLast();
            }else if(s.equals("D")){
                list.add(2*list.getLast());
            }else if(s.equals("+")){
                list.add(list.getLast() + list.get(list.size()-2));
            }else{
                list.add(Integer.parseInt(s));
            }
        }


        Integer sum = list.stream()
                .reduce(0, (a, b) -> a + b);
        return sum;
    }

    public static int calPointsEfficient2(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s: operations) {
            if(s.equals("C")){
                stack.pop();
            }else if(s.equals("D")){
                stack.push(2*stack.peek());
            }else if(s.equals("+")){
                int temp = stack.pop();
                int num = stack.peek()+temp;
                stack.push(temp);
                stack.push(num);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        Integer sum = stack.stream()
                .reduce(0, (a, b) -> a + b);
        return sum;
    }
}
