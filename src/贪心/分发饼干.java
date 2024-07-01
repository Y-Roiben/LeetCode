package 贪心;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        int res= 0;
        // 从大到小排序
        Arrays.sort(g);
        Arrays.sort(s);
        int num = g.length;
        for (int i = s.length - 1; i >= 0; i--) {
            while (num > 0){
                if (s[i] >= g[num - 1]){
                    res++;
                    num--;
                    break;
                }
                num--;
            }
        }
        return res;
    }
}
