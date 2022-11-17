package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack3 {
    Stack<Integer> st = new Stack<>();

    public void push(int x) {
        if(st.isEmpty()){
            st.push(x);
            st.push(x);
        }else{
            int min = st.peek();
            st.push(x);
            st.push(Math.min(min,x));
        }
    }

    public void pop() {
        st.pop();
        st.pop();
    }

    public int top() {
        int min = st.pop();
        int res = st.peek();
        st.push(min);
        return res;
    }

    public int getMin() {
        return st.peek();
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
