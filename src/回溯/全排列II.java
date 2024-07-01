package 回溯;

import java.util.*;
import java.util.stream.Collectors;

public class 全排列II {
    private final List<List<Integer>> res = new ArrayList<>();
    private final List<Integer> list = new ArrayList<>();
    private boolean[] used;
    private int deep = 0;
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
        deep ++;
        for (int i = 0; i < nums.length; i++) {
            //树层去重, 保证相同元素只在同一层使用一次 !used[i-1]没被用过，说明当前属于同一层
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) continue;
            if (used[i]) continue;  // 去除相同位置的元素
            list.add(nums[i]);
            System.out.println("deep:" + deep);
            System.out.println(list);
            used[i] = true;
            backtracking(nums);
            list.removeLast();
            deep --;
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        全排列II solution = new 全排列II();
        List<List<Integer>> res = solution.permuteUnique(new int[]{1, 2, 2, 2});
        System.out.println(res);
    }

}
