package 链表;


public class MyLinkedList {
    int size;
//    虚拟头节点
    ListNode VirtualNode;

    public MyLinkedList() {
        size  = 0;
        VirtualNode = new ListNode();
    }

    public int get(int index) {
        if (index <0 || index >= size){
            return -1;
        }

        ListNode curr = VirtualNode;
//        index = 0
//        curr = head
//        return head.val

//        for (int i = 0; i <= index; i++) {
//            curr = curr.next;
//        }
//        return curr.val;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.next.val;
    }

    public void addAtHead(int val) {
        size++;
        ListNode newNode = new ListNode(val);
        newNode.next = VirtualNode.next;
        VirtualNode.next = newNode;

    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode pred = VirtualNode;
        for (int i = 0; i < size; i++) {
            pred = pred.next;
        }
        pred.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size){
            return;
        }
        ListNode curr = VirtualNode;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        ListNode newNode= new ListNode(val);
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
//         注意等号;
        if (index < 0 || index >= size){
            return;
        }


        ListNode curr = VirtualNode;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}

/*
  Your MyLinkedList object will be instantiated and called as such:
  MyLinkedList obj = new MyLinkedList();
  int param_1 = obj.get(index);
  obj.addAtHead(val);
  obj.addAtTail(val);
  obj.addAtIndex(index,val);
  obj.deleteAtIndex(index);
 */
