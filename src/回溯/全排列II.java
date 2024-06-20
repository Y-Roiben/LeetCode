package 回溯;

import java.util.*;
import java.util.stream.Collectors;

public class 全排列II {
    private final List<List<Integer>> res = new ArrayList<>();
    private final List<Integer> list = new ArrayList<>();
    private final HashSet<Integer> set = new HashSet<>();
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backtracking(nums);
        return res;
    }
    private void backtracking(int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //树层去重, 保证相同元素只在同一层使用一次
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;
            if (used[i]) continue;  // 去除相同位置的元素
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            list.removeLast();
            used[i] = false;
        }
    }

}
