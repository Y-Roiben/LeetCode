package 栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        char[] charArray = s.toCharArray();
//        Deque<Character> stack = new LinkedList<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            }else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
