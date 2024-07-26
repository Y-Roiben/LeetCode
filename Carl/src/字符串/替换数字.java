package 字符串;

import java.util.Scanner;
import java.util.StringJoiner;

public class 替换数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] charArray = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            if (c >= '1' && c <= '9'){
                stringBuilder.append("number");
            }else {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder);
    }
}
