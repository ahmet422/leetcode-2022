package easy;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

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
