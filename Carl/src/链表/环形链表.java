package 链表;

public class 环形链表 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){ // 是环形链表
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
