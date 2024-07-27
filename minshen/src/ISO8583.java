import java.util.Scanner;


/**
 * 当前题目对8583报文进行简化，系统接收若干数据包（每次总数据包不超过10000个字符），
 * 处理之后将处理好的数据包报文返回。每个数据包由位图+报文组成。
 * 位图由0、1组成的长度为10字符串，0表示报文中该序号的域不存在，
 * 1表示报文中该序号的域存在。报文格式如下：1，报文由10个域组成，
 * 每个域由长度+域内容组成，长度由两位数字构成，小于10的前面补0，
 * 内容由数字0-9、字母A-Z组成。2，每个域根据位图来决定是否存在。
 * 处理逻辑如下：如果报文存在第9域，将报文的第9域内容修改为CMBC95568如果报文不存在第9域，
 * 给报文增加第9域，内容为CMBC95568返回：将修改后的报文按照原规则组装返回。
 * 示例1，输入：0000000010101234567890返回09CMBC95568
 * 说明，将数据包用不同颜色表示如下0000000010101234567890的绿色的前十个字符为位图域：
 * 0000000010位图中只有第9位是1，表示报文只有第9域内容为：101234567890前两位是长度，
 * 表示第9域的长度是10，接下来的10个字符就是报文的真实内容故返回09CMBC95568
 * 说明：报文09表示报文内容长度为9，报文CMBC95568是报文内容，按照处理逻辑要求修改为此，长度为9
 * 示例2，输入011000001001A02BC03DEF
 * 说明：位图中第2、3、9位是1，表示报文中存在2、3、9域;
 * 报文01表示域2长度为1，报文A表示域2内容为A
 * 报文02表示域3长度为2，报文BC表示域3内容为BC
 * 报文03表示域9长度为3，报文DEF表示域9内容为DEF
 * 返回01A02BC09CMBC95568
 * 说明：01A02BC为原报文，第9域长度修改为09，内容修改为CMBC95568
 * 示例3，输入：0000000010101234567890001000000004CMBC
 * 说明：此次输入有两个数据包0000000010 101234567890001000000004CMBC
 * 第一个数据包就是示例1的数据。第二个数据包，位图中只有个第3位是1，表示报文中只有第3域；
 * 第二个数据包中报文前两位04表示该域内容长度为4，报文后4位CMBC为报文内容，其长度为4
 * 返回09CMBC9556804CMBC09CMBC95568
 * 说明：09CMBC95568为第一个报文的响应报文，04CMBC09CMBC95568是第二个报文的响应报文，
 * 其中：04CMBC为原报文，后面是增加的第9域，第9域长度为9，第9域报文内容为CMBC95568*/


/**
 * https://acexam.nowcoder.com/coding/?uid=68438E0B8A937BC6&qid=10971871
 * */
public class ISO8583 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int packetLen = 0;

        StringBuilder result = new StringBuilder();
        while (packetLen < input.length()) {
            String bitmap = input.substring(packetLen, 10+packetLen);
            String message = input.substring(10+packetLen);
            boolean field9 = false;
            packetLen += 10;
            for (int i = 0; i < 10; i++) {
                if (bitmap.charAt(i) == '1') {
                    int length = Integer.parseInt(message.substring(0, 2));
                    packetLen = packetLen + 2 + length;
                    String content = message.substring(2, 2 + length);
                    message = message.substring(2 + length);
                    if (i == 8) {
                        content = "CMBC95568";
                        length = content.length();
                        field9 = true;
                    }
                    result.append(String.format("%02d", length)).append(content);
                }
                if (i == 8 &&!field9) {
                    result.append("09CMBC95568");
                }
            }
        }
        System.out.println(result);
    }

}
