package 栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.println(queue.pollFirst());
        }
        System.out.println("---------------------");
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        int size1 = stack.size();
        for (int i = 0; i < size1; i++) {
            System.out.println(stack.pop());
        }


    }
}
