import java.util.*;


/**
 * 微隔离产品有个流量可视的模块，流量可视会图形化展示服务器之间的所有访问关系，其中访问关系需要匹配防火墙策略，以让用户观测该流量是否被放行or拒绝，拒绝的原因是匹配到了某一条防火墙策略。请你设计一个算法来快速完成访问关系的策略匹配。
 * 流量数据和防火墙策略均为五元组(src_ip,src_port,dst_ip,dst_port,protocol)
 * 流量五元组示例和格式说明src_ip：字符串，仅支持ipv4格式。如：1.1.1.1
 * Src_port:整数，1-65535。如：222
 * dst_ip：字符串，仅支持ipv4格式。如：1.1.1.1
 * dst_port:整数，1-65535。如：111
 * protocol:整数：仅支持tcp：17，icmp：1，udp：6防火墙规则示例和格式说明
 * src_ip：字符串，支持ip段/单个ip/任意IP。如：1.1.1.1，1.1.1.1-1.1.10.1,0.0.0.0src_port：字符串，支持端口范围/单个端口/任意端口。如：80,80-90,0
 * dst_ip:字符串，支持ip段/单个ip/任意IP。如：1.1.1.1,1.1.1.1-1.1.10.1,0.0.0.0
 * dst_port：字符串，支持端口范围/单个端口/任意端口。如80，80-90,0
 * protocol:整数，支持17/6/1/0(tcp:17,udp:6,icmp:1，ALL:0)*/

class Flow {
    String srcIp;
    int srcPort;
    String dstIp;
    int dstPort;
    int protocol;

    Flow(String srcIp, int srcPort, String dstIp, int dstPort, int protocol) {
        this.srcIp = srcIp;
        this.srcPort = srcPort;
        this.dstIp = dstIp;
        this.dstPort = dstPort;
        this.protocol = protocol;
    }
}

class FirewallRule {
    int id;
    String srcIp;
    String srcPort;
    String dstIp;
    String dstPort;
    int protocol;

    FirewallRule(int id, String srcIp, String srcPort, String dstIp, String dstPort,
                 int protocol) {
        this.id = id;
        this.srcIp = srcIp;
        this.srcPort = srcPort;
        this.dstIp = dstIp;
        this.dstPort = dstPort;
        this.protocol = protocol;
    }
}

public class TrafficMatcher {

    public static boolean matchFlowToRule(Flow flow, FirewallRule rule) {
        return matchIp(flow.srcIp, rule.srcIp) &&
                matchPort(flow.srcPort, rule.srcPort) &&
                matchIp(flow.dstIp, rule.dstIp) &&
                matchPort(flow.dstPort, rule.dstPort) &&
                (rule.protocol == 0 || flow.protocol == rule.protocol);
    }

    private static boolean matchIp(String ip, String ruleIp) {
        if (ruleIp.equals("0.0.0.0")) return true;
        if (ruleIp.contains("-")) {
            String[] parts = ruleIp.split("-");
            return ipInRange(ip, parts[0], parts[1]);
        }
        return ip.equals(ruleIp);
    }

    private static boolean ipInRange(String ip, String startIp, String endIp) {
        long ipNum = ipToLong(ip);
        return ipNum >= ipToLong(startIp) && ipNum <= ipToLong(endIp);
    }

    private static long ipToLong(String ip) {
        String[] octets = ip.split("\\.");
        return (Long.parseLong(octets[0]) << 24) |
                (Long.parseLong(octets[1]) << 16) |
                (Long.parseLong(octets[2]) << 8) |
                Long.parseLong(octets[3]);
    }

    private static boolean matchPort(int port, String rulePort) {
        if (rulePort.equals("0")) return true;
        if (rulePort.contains("-")) {
            String[] parts = rulePort.split("-");
            int startPort = Integer.parseInt(parts[0]);
            int endPort = Integer.parseInt(parts[1]);
            return port >= startPort && port <= endPort;
        }
        return port == Integer.parseInt(rulePort);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline

//        3 5
//        1 1.1.1.1-1.1.1.255 0 2.2.2.2 222 6
//        2 1.1.1.1 80-81 2.2.2.2-2.2.2.10 80-91 6
//        3 0.0.0.0 0 0.0.0.0 0 0
//        1.1.1.2 222 2.2.2.2 222 6
//        1.1.1.3 222 2.2.2.3 222 6
//        1.1.1.1 81 2.2.2.10 80 6
//        1.1.1.255 81 2.2.2.10 222 17
//        1.1.1.2 50 2.2.2.18 81 6

        // 输出
//        1 3
//        3
//        2 3
//        3
//        3

        List<FirewallRule> rules = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            int id = Integer.parseInt(split[0]);
            String srcIp = split[1];
            String srcPort = split[2];
            String dstIp = split[3];
            String dstPort = split[4];
            int protocol = Integer.parseInt(split[5]);

            rules.add(new FirewallRule(id, srcIp, srcPort, dstIp, dstPort, protocol));
        }

        List<Flow> flows = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] split = scanner.nextLine().split(" ");
            String srcIp = split[0];
            int srcPort = Integer.parseInt(split[1]);
            String dstIp = split[2];
            int dstPort = Integer.parseInt(split[3]);
            int protocol = Integer.parseInt(split[4]);
            flows.add(new Flow(srcIp, srcPort, dstIp, dstPort, protocol));
        }

        for (Flow flow : flows) {
            List<Integer> matchedRuleIds = new ArrayList<>();
            for (FirewallRule rule : rules) {
                if (matchFlowToRule(flow, rule)) {
                    matchedRuleIds.add(rule.id);
                }
            }
            if (matchedRuleIds.isEmpty()) {
                System.out.println(0);
            } else {
                Collections.sort(matchedRuleIds);
                for (int i = 0; i < matchedRuleIds.size(); i++) {
                    if (i > 0) System.out.print(" ");
                    System.out.print(matchedRuleIds.get(i));
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}