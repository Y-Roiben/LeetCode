package 栈与队列;


import java.util.LinkedList;
import java.util.Queue;

class MyStack1{
    private int count;
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public MyStack1() {
        count = 0;
    }

    public void push(int x) {
        queue1.offer(x);
        count++;
    }

    public int pop() {
        for (int i = 0; i < count-1; i++) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.poll();
        count--;
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return res;
    }

    public int top() {
        for (int i = 0; i < count-1; i++) {
            queue2.offer(queue1.poll());
        }
        int res = queue1.peek();
        queue2.offer(queue1.poll());
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return res;
    }

    public boolean empty() {
        return count == 0;
    }
}

class MyStack2{
    private int count;
    Queue<Integer> queue1 = new LinkedList<>();

    public MyStack2(){
        count = 0;
    }

    public void push(int x) {
        queue1.offer(x);
        count++;
    }

    public int pop() {
        for (int i = 0; i < count-1; i++) {
            queue1.offer(queue1.poll());
        }
        int res = queue1.poll();
        count--;
        return res;
    }

    public int top() {
        for (int i = 0; i < count-1; i++) {
            queue1.offer(queue1.poll());
        }
        int res = queue1.peek();
        queue1.offer(queue1.poll());
        return res;
    }

    public boolean empty() {
        return count == 0;
    }
}
public class 用队列实现栈 {

    public static void main(String[] args) {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
}
