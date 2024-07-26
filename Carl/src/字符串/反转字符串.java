package 字符串;

public class 反转字符串 {
    public void reverseString(char[] s) {
//        必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
