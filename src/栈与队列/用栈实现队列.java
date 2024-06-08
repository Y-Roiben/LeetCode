package 栈与队列;

import java.util.Deque;
import java.util.Stack;

class MyQueue {
    private final Stack<Integer> stackIN = new Stack<>();
    private final Stack<Integer> stackOUT = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stackIN.push(x);
    }

    public int pop() {
        dumpStack(stackIN, stackOUT);
        int res = stackOUT.pop();
        dumpStack(stackOUT, stackIN);
        return res;
    }

    public int peek() {
        dumpStack(stackIN, stackOUT);
        int res = stackOUT.peek();
        dumpStack(stackOUT, stackIN);
        return res;
    }

    public boolean empty() {
        return stackIN.isEmpty();
    }

    private void dumpStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        // 将 stack1 中的元素倒入 stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}


class MyQueue2 {
    private final Stack<Integer> stackIN = new Stack<>();
    private final Stack<Integer> stackOUT = new Stack<>();

    public MyQueue2() {
    }

    public void push(int x) {
        stackIN.push(x);
    }

    public int pop() {
       dumpStack();
       return stackOUT.pop();
    }

    public int peek() {
        dumpStack();
        return stackOUT.peek();
    }

    public boolean empty() {
        return stackIN.isEmpty() && stackOUT.isEmpty();
    }
    private void dumpStack(){
        if (stackOUT.isEmpty()){
            while (!stackIN.isEmpty()){
                stackOUT.push(stackIN.pop());
            }
        }
    }
}

public class 用栈实现队列 {
    Deque<Integer> stack1;
//    public static void main(String[] args) {
//        MyQueue queue = new MyQueue();
//        queue.push(1);
//        queue.push(2);
//        System.out.println(queue.peek());  // 返回 1
//        System.out.println(queue.pop());   // 返回 1
//        System.out.println(queue.empty()); // 返回 false
//    }
}