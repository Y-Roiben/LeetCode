package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 翻转二叉树 {

    // 层序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp ;
        int size;
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp = poll.left;
                poll.left = poll.right;
                poll.right = temp;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return root;
    }

    // 递归
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }
}
