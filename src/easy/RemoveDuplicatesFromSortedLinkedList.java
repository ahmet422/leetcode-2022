package easy;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

public class RemoveDuplicatesFromSortedLinkedList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(3);

        l  = deleteDuplicates(l);

        while(l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode node = head;
        while(node.next != null){
            int temp = node.val;
            int nextTemp = node.next.val;
            if(temp == nextTemp){
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
        return head;
    }
}
