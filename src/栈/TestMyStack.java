package 栈;

import java.util.Queue;
import java.util.Stack;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

//        Stack<Integer> stack1 = new Stack<>();
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(3);
//        stack1.push(4);
//        while (!stack1.isEmpty()) {
//            System.out.println(stack1.pop());
//        }


    }
}
