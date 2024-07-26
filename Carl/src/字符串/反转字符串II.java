package 字符串;

public class 反转字符串II {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i = i+ 2 * k) {
            if (i + k <= charArray.length){
                reverseString(charArray, i, i+ k);
            }else {
                reverseString(charArray, i, charArray.length);
            }
        }


        return new String(charArray);
    }

    public void reverseString(char[] s, int star, int end) {
//        必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
        int left = star;
        int right = end - 1;
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
