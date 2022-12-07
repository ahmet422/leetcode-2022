package easy;

public class RemoveLinkedListElements {


    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(6);
        head.next.next = new ListNode(6);
        head.next.next.next= new ListNode(6);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(6);

        head = removeElementsEfficient(head, 6);


        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

        System.out.println("End");
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        if(head.next == null && head.val == val) head = null;
        if(head == null) return head;

        while(head.val == val && head.next != null ){
            node = head.next;
            head = node;
        }

        if(head.next == null && head.val == val) head = null;
        if(head == null) return head;

        while(node.next != null){
            if(node.next.val != val){
                node = node.next;
            }else{
                node.next = node.next.next;
            }
        }

        return head;
    }

    public static ListNode removeElementsEfficient(ListNode head, int val) {
        if(head==null)
            return head;

        ListNode prev=head ;
        ListNode curr=head.next ;
        while(curr!=null){
            if(curr.val==val){
                prev.next=curr.next;
                curr=curr.next;
            }
            else{
                prev=curr;
                curr=curr.next;
            }
        }
        if(head.val==val)
            return head.next;
        return head;
    }


}
