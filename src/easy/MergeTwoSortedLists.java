package easy;
// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(25);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);


        ListNode m = new ListNode(1);
        m.next = new ListNode(3);
        m.next.next = new ListNode(3);
        m.next.next.next = new ListNode(5);
        m.next.next.next.next = new ListNode(6);

        ListNode n = mergeTwoLists(l,m);

        while(n != null){
            System.out.println(n.val);
            n = n.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode myNode = new ListNode(-1);
        ListNode head = myNode;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                myNode.next = l1;
                l1 = l1.next;
            }else{
                myNode.next = l2;
                l2 = l2.next;
            }
            myNode = myNode.next;
        }

        if(l1 != null){
            myNode.next = l1;
        }
        else{
            myNode.next = l2;
        }


        return head.next;
    }

    public static ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val<l2.val){
            l1.next = mergeTwoListsRecursive(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoListsRecursive(l1,l2.next);
            return l2;
        }
    }
}
