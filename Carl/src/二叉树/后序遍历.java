package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;

    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }
}
