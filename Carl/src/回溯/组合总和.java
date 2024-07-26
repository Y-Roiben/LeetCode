package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    private final List<List<Integer>> res = new ArrayList<>();
    private final List<Integer> list = new ArrayList<>();
    private int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    private void backtracking(int k, int n, int startIndex) {
        if (list.size() == k){
            if (sum == n){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        // 剪枝操作
        if (n - sum < startIndex){
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            list.add(i);
            sum += i;
            backtracking(k, n, i + 1);
            sum -= i;
            list.removeLast();
        }

    }
}
