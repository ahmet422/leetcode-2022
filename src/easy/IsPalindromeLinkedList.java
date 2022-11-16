package easy;
//
public class IsPalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode prev = null;
        ListNode current = head;
        ListNode fast = head;

        while (fast !=null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
            head = prev;
        }

        if(fast != null)
            current = current.next;

        while(current != null){
            if(head.val != current.val)
                return false;
            current = current . next;
            head = head.next;
        }

        return true;
    }
}
