package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    private List<List<String>> res = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) return null;
        backtracking(charArray, 0);
        return res;
    }

    private void backtracking(char[] chars, int startIndex){
        if (startIndex == chars.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < chars.length; i++) {
            if (isPalindrome(chars, startIndex, i)){
                list.add(new String(chars, startIndex, i - startIndex + 1));
            }else {
                continue;
            }
            backtracking(chars, i + 1);
            list.removeLast();
        }

    }

    // 判断是否是回文串
    private boolean isPalindrome(char[] chars, int left, int right){
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
