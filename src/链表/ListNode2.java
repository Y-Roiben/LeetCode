package 链表;

public class ListNode2 {
    int val;
    ListNode2 next, prev;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next, ListNode2 prev) { this.val = val; this.next = next; this.prev = prev;}
}
