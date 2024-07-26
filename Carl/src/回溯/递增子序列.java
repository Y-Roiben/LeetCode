package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 递增子序列 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return res;
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex){
        if (list.size() >= 2){
            res.add(new ArrayList<>(list));
        }
//        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
//            if (i >startIndex && set.contains(nums[i])) continue;
            if (i >startIndex && isRepeat(nums, startIndex, i)) continue;
            if (list.isEmpty() || nums[i] >= list.getLast()){
                list.add(nums[i]);
//                set.add(nums[i]);
                backtracking(nums, i + 1);
                list.removeLast();
            }
        }
    }

    // 判断是否有重复元素
    private boolean isRepeat(int[] nums, int startIndex, int index){
        for (int i = startIndex; i < index; i++) {
            if (nums[i] == nums[index]){
                return true;
            }
        }
        return false;
    }

}
