package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    private final List<String> res = new ArrayList<>();
    private final List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        char[] charArray = s.toCharArray();
        backtracking(charArray, 0);
        return res;
    }
    private void backtracking(char[] chars, int startIndex){
        if (list.size() == 4){
            if (startIndex == chars.length){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size() - 1; i++) {
                    stringBuilder.append(list.get(i)).append(".");
                }
                stringBuilder.append(list.getLast());
                res.add(stringBuilder.toString());
            }
            return;
        }
        int end = Math.min(startIndex + 3, chars.length);

        for (int i = startIndex; i < end; i++) {
            String substr = new String(chars, startIndex, i - startIndex + 1);
            if (isValid(substr)){
                list.add(substr);
            }else {
                break;
            }
            backtracking(chars, i + 1);
            list.removeLast();
        }

    }

    // 判断是否合法
    private boolean isValid(String str){
        if (str.length() > 1 && str.charAt(0) == '0') return false;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') return false;
            num = num * 10 + (str.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }




}
