package 链表;

public class 两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
//      dummyHead ->  1 -> 2 -> 3
//      dummyHead ->  2 -> 1 -> 3
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while (curr.next != null && curr.next.next != null ){
            ListNode temp1 = curr.next;
            ListNode temp3 = curr.next.next.next;
            curr.next = curr.next.next;
            curr.next.next = temp1;
            temp1.next = temp3;
            curr = curr.next.next;
//            curr = temp1;
        }
        return dummyHead.next;
    }
}
