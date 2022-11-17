package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String []{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s: tokens) {
            if(s.equals("+")){
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n1+n2);
            }else if(s.equals("-")){
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n2-n1);
            }else if(s.equals("*")){
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n1*n2);
            }else if(s.equals("/")){
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n2/n1);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}
