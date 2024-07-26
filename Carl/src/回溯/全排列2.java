package 回溯;

import java.util.*;

public class 全排列2 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // nums去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (used[i]) continue;
            list.add(nums[i]);
            set.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            list.removeLast();
            used[i] = false;
        }
    }
}
