package 链表;

import java.util.HashSet;

public class 链表相交 {
//    暴力
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        while (currA != null){
            ListNode currB =  headB;
            while (currB != null){
                if (currA == currB){
                    return currA;
                }
                currB = currB.next;
            }
            currA = currA.next;
        }

        return null;
    }

//  双指针
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = (currA != null) ? currA.next : headB;
            currB = (currB != null) ? currB.next : headA;
        }

//        如果不相交其长度相等, 到尾指针为A B 都为null，return null;
//        不相等相当是两链表进行拼接， 长度又变成相等的了

//        如果链表长度相等且相交, 由于相交部分长度是一样的，所以不相交的长度也是一样的, 会同时到达交点

        return currA;
    }

//    hash表
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode>  listNodes = new HashSet<>();
        ListNode currA = headA;
        while (currA != null){
            listNodes.add(currA);
            currA = currA.next;
        }

        ListNode currB = headB;
        while (currB != null){
            if (listNodes.contains(currB)){
                return currB;
            }
            currB = currB.next;
        }

        return null;
}


}
