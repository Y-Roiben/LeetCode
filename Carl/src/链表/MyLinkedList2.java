package 链表;


 class MyLinkedList2 {

     int size ;

     ListNode2 virtualHeadNode, virtualTailNode;

    public  MyLinkedList2() {
        size = 0;
        virtualHeadNode = new ListNode2();
        virtualTailNode = new ListNode2();
        virtualHeadNode.next = virtualTailNode;
        virtualTailNode.prev = virtualHeadNode;
    }

    public int get(int index) {

        if (index < 0 || index >= size){
            return -1;
        }
//        判断是从头节点还是尾节点开始遍历

        if (index < size / 2){
            // 从头结点开始往后遍历
            ListNode2 curr = virtualHeadNode;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.next.val;
        }else {
            // 从尾节点开始往前遍历
            ListNode2 curr = virtualTailNode;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
            return curr.prev.val;
        }

    }

    public void addAtHead(int val) {
        ListNode2 newNode= new ListNode2(val);

        newNode.prev = virtualHeadNode;
        newNode.next = virtualHeadNode.next;
        virtualHeadNode.next.prev = newNode;
        virtualHeadNode.next = newNode;
        size++;

    }

    public void addAtTail(int val) {

        ListNode2 newNode = new ListNode2(val);
        ListNode2 prev = virtualTailNode.prev;

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = virtualTailNode;
        virtualTailNode.prev  = newNode;
        size++;


    }

    public void addAtIndex(int index, int val) {

        if (index <0 || index > size){
            return;
        }

        ListNode2 curr = virtualHeadNode;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        ListNode2 newNode = new ListNode2(val);
        ListNode2 currNextNode = curr.next;
        currNextNode.prev = newNode;
        newNode.prev = curr;
        newNode.next = currNextNode;
        curr.next = newNode;
        size++;

    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size){
            return;
        }


        if (index < size / 2){
            // 从头结点开始往后遍历
            ListNode2 curr = virtualHeadNode;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
//            要删除的那个元素
            curr = curr.next;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

        }else {
            // 从尾节点开始往前遍历
            ListNode2 curr = virtualTailNode;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }

//            要删除的那个元素
            curr = curr.prev;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

        }

        size--;

    }

}


