package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        if (nums.length == 0) return res;
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex){
        res.add(new ArrayList<>(list));
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}
