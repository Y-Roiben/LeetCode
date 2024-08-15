package 贪心;

import java.util.Arrays;

public class 单调递增的数字 {
    public int monotoneIncreasingDigits(int n) {
        char[] charArray = ("" + n).toCharArray();
        int flag = charArray.length; // 哪里开始变成9
        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] < charArray[i-1]){
                charArray[i-1] = (char) (charArray[i-1] - 1);
                flag = i;
            }
        }
        for (int i = flag; i < charArray.length; i++) {
            charArray[i] ='9';
        }
        return Integer.parseInt(new String(charArray));
    }
}
