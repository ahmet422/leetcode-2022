package medium;

import easy.ListNode;
import org.w3c.dom.NodeList;

import java.util.Stack;

public class ReorderList {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = new ListNode(7);

        ListNode node = n1;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }

        System.out.println();
        reorderList2(n1);


    }
    public static void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null  ){
            slow = slow.next;
            fast = fast.next.next;
        }


        System.out.println("Slow value: " + slow.val);

        Stack<ListNode> st = new Stack<>();

        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;

        while(slow != null){
            ListNode s = slow;
            s = slow.next;
            slow.next = null;
            st.add(slow);
            slow = s;
        }

        ListNode node = head;
        ListNode tempNode = head;
        while(!st.isEmpty()){
            node = node.next;
            tempNode.next = st.pop();
            tempNode = tempNode.next;
            tempNode.next = node;
            tempNode = node;
        }

        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("End");
    }

    public static void reorderList2(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null  ){
            slow = slow.next;
            fast = fast.next.next;
        }


//        System.out.println("Slow value: " + slow.val);

        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;

        ListNode prev = null;
        //reverse linked list
        while(slow != null){
            ListNode node = slow;
            slow = slow.next;
            node.next = prev;
            prev = node;
        }

        ListNode head2 = prev;
        ListNode curr2 = head2;
        ListNode prev2 = head2;
        ListNode curr1 = head;
        ListNode prev1 = head;
        while(curr2 != null){
            curr1 = curr1.next;
            curr2 = curr2.next;
            prev2.next = null;
            prev1.next = prev2;
            prev2.next = curr1;
            prev1 = curr1;
            prev2 = curr2;
        }


        ListNode trav = head;

        while(trav != null){
            System.out.print(trav.val + " -> ");
            trav = trav.next;
        }

    }
}
