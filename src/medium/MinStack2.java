package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack2 {
    List<List<Integer>> list = new ArrayList<>();

    public void push(int x) {
        List<Integer> temp = new ArrayList<>();
        if(list.isEmpty()){
            temp.add(x);
            temp.add(x);
        }else{
            temp.add(x);
            temp.add(Math.min(x,list.get(list.size()-1).get(1)));
        }
        list.add(temp);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1).get(0);
    }

    public int getMin() {
        return list.get(list.size()-1).get(1);
    }

    public static void main(String[] args) {
        MinStack2 st = new MinStack2();
        st.push(-2);
        st.push(0);
        st.push(-3);
        System.out.println(st.getMin());

        st.pop();

        System.out.println(st.top());
        System.out.println(st.getMin());
    }
}
