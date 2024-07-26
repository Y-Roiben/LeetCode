import java.util.*;

public class 滑动窗口 {
    public static void main(String[] args) {
//        无重复字符的最长子串

        HashMap<Character, Integer> map = new HashMap<>();

        Integer index = map.put('a', 5);
        System.out.println(map.put('a', 10));
        System.out.println(index);

        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        char ch;
        int max_len = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            Integer index = map.put(ch, i);
            if (index != null && index >= left) {
//                注意index 要大于等于left
//                index 限制在map中的查询, 重复字符在窗口内才会缩减窗口
                left = index + 1;
            }
            right++;
            max_len = Math.max(max_len, right - left);

        }
        return max_len;
    }


}
