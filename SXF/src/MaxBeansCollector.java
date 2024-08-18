import java.util.Scanner;

/**
 * 1条路上依次排列着N个七色豆，七种颜色分别用字符abcdefg表示。
 * 1条机器小人沿着这条路往前捡豆豆机器小人会按下发给它的指令串进行动作。
 * 指令串由abcdefg*这八个字符组成。其中abcdefg是豆豆的颜色，表示机器小人接下来可以捡一粒该颜色的豆豆。
 * 如果指令串接下来出现*这个字符，表示机器小人可以重复前一个动作任意多次（包括0次）。如果指令串执行结束，
 *或者遇到当前指令不能匹配的豆豆，机器小人停止前进。求机器小人最多可以捡到多少个豆豆。
 * 1条路上依次排列着N个七色豆，七种颜色分别用字符abcdefg表示。
 * 1条机器小人沿着这条路往前捡豆豆机器小人会按下发给它的指令串进行动作。
 * 指令串由abcdefg*这八个字符组成。其中abcdefg是豆豆的颜色，
 * 表示机器小人接下来可以捡一粒该颜色的豆豆。如果指令串接下来出现*这个字符，
 * 表示机器小人可以重复前一个动作任意多次（包括0次）。如果指令串执行结束，
 * 或者遇到当前指令不能匹配的豆豆，机器小人停止前进。求机器小人最多可以捡到多少个豆豆。*/

public class MaxBeansCollector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取豆豆序列
        String beans = scanner.nextLine();

        // 读取指令串
        String instructions = scanner.nextLine();

        int n = beans.length();
        int m = instructions.length();

        int beanIndex = 0;
        int instructionIndex = 0;
        int maxBeans = 0;

        while (beanIndex < n && instructionIndex < m) {
            if (instructions.charAt(instructionIndex) == beans.charAt(beanIndex)) {
                maxBeans++;
                beanIndex++;
                instructionIndex++;
            } else if (instructions.charAt(instructionIndex) == '*') {
                if (instructionIndex == 0) {
                    break;
                } else {
                    char prevInstruction = instructions.charAt(instructionIndex - 1);
                    while (beanIndex < n && beans.charAt(beanIndex) == prevInstruction) {
                        maxBeans++;
                        beanIndex++;
                    }
                    instructionIndex++;
                }
            } else {
                instructionIndex++;
            }
        }
        System.out.println(maxBeans);
        scanner.close();
    }
}