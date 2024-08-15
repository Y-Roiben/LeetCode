package 滑动窗口;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        char[] charArray = s.toCharArray();
        int[] map = new int[128];
        Arrays.fill(map, -1);

        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            int oldIndex = map[charArray[i]];
            map[charArray[i]] = i;
            right++;
            if (oldIndex != -1 && oldIndex >= left){
                // 等于
                left = oldIndex+1;
            }
            max = Math.max(max, right-left);
        }

        return max;

    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) return 0;

        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            Integer oldIndex = map.put(charArray[i], i);
            right++;
            if (oldIndex != null && oldIndex >= left){
                // 等于
                left = oldIndex+1;
            }
            max = Math.max(max, right-left);
        }

        return max;
    }
}
