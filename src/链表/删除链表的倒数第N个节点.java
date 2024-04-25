package 链表;

public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow =  dummyHead;
        ListNode fast = dummyHead;

//        快指针走n+1步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
//        快指针走到最后一个
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
//        快指针走到最后一个
//        中间隔了n个节点，此时slow的下一个就是要删除的那个
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
