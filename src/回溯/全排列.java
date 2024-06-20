package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        backtracking(nums);
        return res;
    }
    private void backtracking(int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) continue;
            list.add(num);
            backtracking(nums);
            list.removeLast();
        }
    }
}
