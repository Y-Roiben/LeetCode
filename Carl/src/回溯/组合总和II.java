package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 组合总和II {
    private final List<List<Integer>> res = new ArrayList<>();
    private int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, list);
        return res;
    }

    public void backtracking(int[] candidates, int target,
                             int startIndex, List<Integer> list){
        if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - sum < candidates[i]){
                return;
            }
            //跳过同一树层使用过的元素
            if (i > startIndex && candidates[i] == candidates[i - 1]){
                continue;
            }
            sum += candidates[i];
            list.add(candidates[i]);
            backtracking(candidates, target, i + 1, list);
            sum -= candidates[i];
            list.removeLast();
        }
    }
}
