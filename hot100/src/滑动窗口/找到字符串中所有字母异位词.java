package 滑动窗口;

import java.util.*;

public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int[] map = new int[128]; // 收集字母出现次数
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)] += 1;
        }

        int sLen = s.length();
        int pLen = p.length();
        int[] compare = new int[128];


        // 初始化窗户内容
        for (int i = 0; i < pLen; i++) {
            compare[s.charAt(i)] += 1;
        }
        if (Arrays.equals(compare, map)){
            res.add(0);
        }
        for (int i = 1; i <= sLen - pLen; i++) {
            // 滑动窗口, 修改窗口内内容
            compare[s.charAt(i-1)] -=1;
            compare[s.charAt(i + pLen - 1)] += 1;
            if (Arrays.equals(compare, map)){
                res.add(i);
            }
        }

        return res;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int[] map = new int[128]; // 收集字母出现次数
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)] += 1;
        }

        int sLen = s.length();
        int pLen = p.length();

        for (int i = 0; i <= sLen - pLen; i++) {
            boolean flag = true;  // 是否收集结果
            int[] temp = Arrays.copyOf(map, 128);
            for (int j = 0; j < pLen; j++) {
                char c = s.charAt(j+i);
                int num = temp[c];
                if (num == 0){
                    flag = false;
                    break;
                }
                temp[c] -=1;
            }
            if (flag){
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        int subLen = p.length();
        char[] subChar = p.toCharArray();
        Arrays.sort(subChar);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length()-subLen; i++) {
            char[] subS = new char[subLen];
            for (int j = 0; j < subLen; j++) {
                subS[j] = s.charAt(i+j);
            }
            Arrays.sort(subS);
            if (Arrays.equals(subS, subChar)){
                res.add(i);
            }
        }

        return res;
    }
}
