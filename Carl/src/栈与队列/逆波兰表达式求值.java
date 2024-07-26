package 栈与队列;

import java.util.Deque;
import java.util.LinkedList;

public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(Integer.parseInt(token));
            }else {
                Integer first = stack.pop();
                Integer second = stack.pop();
                switch (token) {
                    case "+" -> {
                        stack.push( second + first);
                    }
                    case "-" -> {
                        stack.push(second - first);
                    }
                    case "*" -> {
                        stack.push(second * first);
                    }
                    case "/" ->{
                        stack.push(second / first);
                    }
                }
            }
        }
        return stack.pop();
    }

    public int evalRPN1(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push( stack.pop() + stack.pop());
                case "-" -> stack.push(-stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" ->{
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second / first);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
    public int evalRPN3(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            }else if ("-".equals(token)) {
                stack.push(- stack.pop() + stack.pop());
            }else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            }else if ("/".equals(token)) {
                Integer first = stack.pop();
                Integer second = stack.pop();
                stack.push(second / first);
            }else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

}
