package medium;
// https://leetcode.com/problems/min-stack/description/
public class MinStack {
class Node{
    int value;
    int min;
    Node next;

    Node(int value, int min){
        this.value = value;
        this.min = min;
        this.next = null;
    }
}
    Node head;

    public void push(int x) {
        if(head == null){
            head = new Node(x,x);
        }else{
            Node temp = new Node(x, Math.min(x, head.min));
            temp.next = head;
            head = temp;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }
}
