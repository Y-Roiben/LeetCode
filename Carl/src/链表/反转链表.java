package 链表;

public class 反转链表 {
//    双指针
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

//    递归
    public ListNode reverseList1(ListNode head) {

    ListNode cur = head;
    ListNode pre = null;
    ListNode temp;
    while (cur != null){
        temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
    }
    return cur;
}
}
