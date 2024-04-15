import 链表.MyLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Object MyLinkedList;
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        int i = myLinkedList.get(4);
        myLinkedList.addAtHead(4);

    }
}