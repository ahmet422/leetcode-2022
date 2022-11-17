package easy;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode m = new ListNode(1);
        m.next = new ListNode(3);
        m.next.next = new ListNode(3);
        m.next.next.next = new ListNode(5);
        m.next.next.next.next = new ListNode(6);

        ListNode n = reverseList(m);
        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while(head != null){
            ListNode temp = head;
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
