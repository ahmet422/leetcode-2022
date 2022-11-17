package easy;
// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i = 1; i<queue.size(); i++){
           int temp = queue.remove();
            queue.add(temp);
        }
    }

    public void pop() {
        queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "queue=" + queue +
                '}';
    }

    public static void main(String[] args) {
        MyStack st = new MyStack();

        st.push(12);
        st.push(13);
        st.push(15);

        System.out.println(st);

        st.pop();
        System.out.println(st);

        System.out.println(st.empty());

        System.out.println(st.top());
    }
}
