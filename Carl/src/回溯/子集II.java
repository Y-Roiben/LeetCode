package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集II {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return res;
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex){
        res.add(new ArrayList<>(list));

        for (int i = startIndex; i < nums.length; i++) {
            if (startIndex < i && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
