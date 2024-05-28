package 字符串;

import java.util.StringJoiner;

public class 翻转字符串里的单词 {
    public String reverseWords(String s) {

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
