package 链表;

public class 移除链表元素 {
    /*
      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     */


    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode current = head;

        while (current != null && current.next != null){
            if (current.next.val == val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }

        return head;
    }
    public ListNode removeElements1(ListNode head, int val) {
//        虚拟头节点
        ListNode node = new ListNode();
        node.next = head;
        ListNode current = node;

        while (current.next != null){
            if (current.next.val == val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }

        return node.next;
    }


}
