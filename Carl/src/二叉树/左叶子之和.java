package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 左叶子之和 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;

        int res = 0;
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int res = 0;

        // 后序遍历
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {  // 是左叶子节点
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves1(root.left);
            }
        }
        if (root.right != null) {
            res += sumOfLeftLeaves1(root.right);
        }
        return res;

    }

}
