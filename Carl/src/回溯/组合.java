package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    private static final List<List<Integer>> res = new ArrayList<>();
    private static final List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {

        backtracking(n, k, 1);
        return res;
    }

    public static void backtracking(int n, int k, int startIndex){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        // 剪枝操作
        // 总共有n个数， 要k个，
        // (n - i) >= k - size
        for (int i = startIndex; i <= n - k + list.size() + 1; i++) {
            list.add(i);
            backtracking(n, k, i + 1);
            list.removeLast();
        }

//        for (int i = startIndex; i <= n; i++) {
//            list.add(i);
//            backtracking(n, k, i + 1);
//            list.removeLast();
//        }
    }

    public static void main(String[] args) {
        combine(4, 2);
        System.out.println(res);
    }

}
