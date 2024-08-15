package 字符串;

public class 找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        // TODO: KMP算法


        return -1;
    }


    // 前缀表
    public static int[] getNext(String needle){
        int[] next = new int[needle.length()];
        next[0] = 0;
        int j = 0;  // 前缀末尾位置
        for (int i = 1; i < needle.length(); i++) {  // 后缀末尾位置
            while (j > 0 && needle.charAt(j) != needle.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == needle.charAt(i))
                j++;
            next[i] = j;
        }

        return next;
    }

    public static void main(String[] args) {

    }
}
