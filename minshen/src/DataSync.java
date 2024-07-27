import java.util.*;

/**
 * 对于银行的重要系统，都需要数据库的几余部署，若你负责开发数据同步功能。你的任务是将主数据库的变更数据实时同步到多个备用数据库。
 * 每个备用数据库都有其自身的网络状况和处理能力。为了提高同步效率，你需要根据它们的负载情况动态调整数据同步策略。
 * 现在，你有一系列数据变更事件需要同步，每个事件可以是插入操作或删除操作。你可以将连续的事件打包成一个事务进行同步，
 * 每个事务只能包含一种类型的操作（插入或删除）。给定以下信息：n:数据库中数据变更事件的总数。范围为[1,3*105]。
 * m:备用数据库的数量。范围为[1，10]。events：一个长度为n的整数数组，表示数据变更事件序列，
 * 其中 events[i表示第i个事件的类型，0表示插入操作，1表示删除操作。bandwidth:一个长度为 m的整数数组，
 * 其中 bandwidth[j]表示第j个备用数据库每秒最多可以同步的事件数量。范围为[1,104]。latency:一个长度为 m的整数数组，
 * 其中 latency[j]表示将一个事务同步到第j个备用数据库所需的延迟（以秒为单位）。范围为[1,10]。
 * 你的目标是设计一种数据同步策略，最小化所有数据变更事件同步到所有备用数据库所需的总时间。
 * 输入描述n=5,m=2,events = [0, 1, 0, 1, 0]
 * ,bandwidth = [2, 1],latency = [1, 2]
 * 输入共5行，程序应忽略输入数据中的空格第1行数据为整数n，意为数据库中数据变更事件的总数，
 * 范围为[1,3*10^5]。第2行数据为整数m，意为备用数据库的数量，范围为[1，10]。
 * 第3行数据为长度是n的整数数组events，以半角逗号,分隔，表示数据变更事件序列，
 * 其中events[i]表示第i个事件的类型，0表示插入操作，1表示删除操作，数组的值仅为0或1。
 * 第4行数据为长度是m数值的整数数组bandwidth，以半角逗号,分隔，
 * 其中bandwidth[j]表示第j个备用数据库每秒最多可以同步的事件数量，
 * 范围为[1,10^4]。第5行数据为长度是m的整数数组latency，以半角逗号,分隔，
 * latencyi表示将一个事务同步到第j个备用数据库所需的延迟（以秒为单位），范围为[1,10]。
 * 输出描述整型数值，意为最小同步时间。
 * 示例 1输入
 * 5
 * 1
 * 0, 0, 1, 1, 0
 * 2
 * 1
 * 输出
 * 3
 * 说明
 * 共有5个事件，1个备用数据库，带宽为2，意味着一次最多可以同步2个事件，同步一次事件的时间为1秒，
 * 则对于事件列表{0,0,1,1,0},可以将相同的连续事件合并，且满足带宽2，则可一次同步2个插入事件，
 * 2个删除事件，然后再同步最后一个插入事件，最后耗时为3s*/
/**
 * https://acexam.nowcoder.com/coding/?uid=68438E0B8A937BC6&qid=10971932
 * */
public class DataSync {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        int n = Integer.parseInt(scanner.nextLine().trim());
        int m = Integer.parseInt(scanner.nextLine().trim());
        int[] events = Arrays.stream(scanner.nextLine().trim().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        int[] bandwidth = Arrays.stream(scanner.nextLine().trim().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();
        int[] latency = Arrays.stream(scanner.nextLine().trim().split("\\s*,\\s*")).mapToInt(Integer::parseInt).toArray();



        // Iterate through events to group consecutive events of the same type
        int i = 0;
        int[] times = new int[m];
        while (i < n) {
            int eventType = events[i];
            int transactionSize = 0;

            // Group consecutive events of the same type
            while (i < n && events[i] == eventType) {
                transactionSize++;
                i++;
            }

            // Calculate the minimum time to synchronize this transaction to any backup database
            int minSyncTime = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                int syncTime = (int) Math.ceil((double) transactionSize / bandwidth[j]) * latency[j];
                times[j] += syncTime;
            }

        }

        // Output the total minimum synchronization time
        int max = 0;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, times[j]);
        }
        System.out.println(max);
    }
}