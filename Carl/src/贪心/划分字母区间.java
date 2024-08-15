package 贪心;

import java.util.*;

public class 划分字母区间 {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        // 记录字母出现的最大索引
        int[] map = new int[128];
        for (int i = 0; i < charArray.length; i++) {
            map[charArray[i]] = i;
        }

        int end = map[charArray[0]];
        int lastEnd = 0;

        for (int i = 0; i < charArray.length; i++) {
            end = Math.max(end, map[charArray[i]]);
            if (end <= i){
                res.add(end + 1 - lastEnd);
                lastEnd = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list);
    }
}
