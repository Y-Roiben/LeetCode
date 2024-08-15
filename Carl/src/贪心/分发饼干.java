package 贪心;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        int res= 0;
        // 从小到大排序
        Arrays.sort(g);  // 胃口
        Arrays.sort(s);  // 食物
        int num = g.length;
        for (int i = s.length - 1; i >= 0; i--) {
            // 优先满足胃口大的
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
