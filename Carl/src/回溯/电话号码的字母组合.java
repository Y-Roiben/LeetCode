package 回溯;

import java.util.HashMap;
import java.util.List;

public class 电话号码的字母组合 {
    HashMap<Character, String> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] charArray = digits.toCharArray();
        build(0, charArray, new StringBuilder());
        return res;
    }

    public void build(int index, char[] charArray, StringBuilder sb){
        // 终止条件
        if (index == charArray.length){
            res.add(sb.toString());
            return;
        }
        // 处理当前层
        char c = charArray[index];
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            build(index + 1, charArray, sb);
            sb.deleteCharAt(sb.length() - 1); // 删除最后一个字符，回溯
        }
    }
}
