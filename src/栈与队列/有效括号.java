package 栈与队列;

import java.util.*;

public class 有效括号 {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0){
            return false;
        }
        Map<Character, Character> leftMap = new HashMap<>();
        leftMap.put('(', ')');
        leftMap.put('[', ']');
        leftMap.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (leftMap.containsKey(c)){
                stack.push(leftMap.get(c));
            }else {
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(')');
            }else if (c == '[') {
                stack.push(']');
            }else if (c == '{') {
                stack.push('}');
            }else if (c == ')'){
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }else if (c == ']'){
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }else if (c == '}'){
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        for (char c : charArray) {
            if (c == '(') {
                stack.push(')');
            }else if (c == '[') {
                stack.push(']');
            }else if (c == '{') {
                stack.push('}');
            }else if (c == ')'){
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }else if (c == ']'){
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }else if (c == '}'){
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
