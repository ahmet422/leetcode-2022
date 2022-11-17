package easy;
// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node;
        System.out.println(hasCycle(node));
    }

    public static boolean hasCycle(ListNode head) {

        if(head == null) return false;
        if(head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}
