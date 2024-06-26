import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class debug {
    public static void main(String[] args) {
        String s = "  the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        String[] words = s.split("\\s+");

        // 创建一个 StringBuilder 用于构建反转后的字符串
        StringJoiner reversedString = new StringJoiner(" ");

        // 将单词数组反向遍历并添加到 StringBuilder 中

        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()){
                reversedString.add(words[i]);
            }
        }
        // 返回反转后的字符串
        return reversedString.toString();

    }
}