package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        paths(root, path, res);
        for (List<Integer> re : res) {
            int sum = 0;
            for (Integer integer : re) {
                sum += integer;
            }
            if (sum == targetSum){
                return true;
            }
        }
        return false;
    }

    public void paths(TreeNode tree, List<Integer> path, List<List<Integer>> res){
        path.add(tree.val);
        if (tree.left == null && tree.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (tree.left != null) {
            paths(tree.left, path, res);
            path.removeLast();  // 这里是关键，因为path是引用传递，所以要回溯
        }
        if (tree.right != null) {
            paths(tree.right, path, res);
            path.removeLast();
        }
    }


    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traverse(root, targetSum);
    }

    boolean traverse(TreeNode node, int target){
        if (node.left == null && node.right == null) {
            // 遇到叶子节点
            return (target - node.val) == 0;
        }
        int i = target - node.val;
        if (node.left != null) {
            boolean left = traverse(node.left, i);
            if (left) return true;
        }
        if (node.right != null) {
            boolean right = traverse(node.right, i);
            if (right) return true;
        }
        return false;
    }



}
