package easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class ListNodeDetectCycle {
    public static void main(String[] args) {
        ListNode n9 = new ListNode(-5);
        ListNode n8 = new ListNode(-2,n9);
        ListNode n7 = new ListNode(-5,n8);
        ListNode n6 = new ListNode(-9, n7);
        ListNode n5 = new ListNode(6,n6);
        ListNode n4 = new ListNode(19,n5);
        ListNode n3 = new ListNode(4,n4);
        ListNode n2 = new ListNode(7,n3);
        ListNode n1 = new ListNode(-7, n2);
        ListNode n0 = new ListNode(-1,n1);
        n9.next = n6;

        detectCycle(n0);

    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        Set<ListNode> set = new HashSet<>();
        int l = 0;
        // length
        while(slow!=null){
            if(set.contains(slow)){
                break;
            }
            l++;
            set.add(slow);
            slow = slow.next;
        }
        System.out.println(set.size());
        slow = head;
        set.clear();

        while(fast != null && fast.next != null){
            if(set.contains(fast)){
                break;
            }
            set.add(slow);

            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null || fast.next == null) {
            System.out.println("no cycle");
            return null;
        }
        if(fast.next == head){
            return head;
        }

        if(l%2==0) {
            System.out.println("yooooo" + fast.val);
            return fast;

        }
        // int index = 0;
        while(head.next != fast){
            head = head.next;
            // index++;
        }

        if(l%2==1){
            return head;
        }else {
            // System.out.println("tail connects to node index " + index);
            return fast;
        }
//        return fast;
    }

    public static ListNode detectCycleEfficient(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
