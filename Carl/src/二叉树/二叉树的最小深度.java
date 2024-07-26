package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (node.left == null && node.right == null) {
                    return depth;
                }
            }
        }
        return depth;
    }
}
