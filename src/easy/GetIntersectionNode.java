package easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class GetIntersectionNode {
    public static void main(String[] args) {

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB!=null){
            if(!set.add(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while(headA != null || headB != null){
            if(headA == null || headB == null) return null;
            if(headA != null){
                if(!set.add(headA)) return headA;
                headA = headA.next;
            }
            if(headB != null){
                if(!set.add(headB)) return headB;
                headB = headB.next;
            }
        }
        return null;
    }

    public static ListNode getIntersectionNodeEfficient(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }
}
