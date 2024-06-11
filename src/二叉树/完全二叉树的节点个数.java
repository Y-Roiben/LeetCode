package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 完全二叉树的节点个数 {

    // 层序遍历
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int count = 0;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                count++;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return count;
    }


    public int countNodes1(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);
        return left + right + 1;
    }
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (left != null){
            left = left.left;
            leftDepth++;
        }
        while (right != null){
            right = right.right;
            rightDepth++;
        }
        if (rightDepth == leftDepth){
            return 2 << leftDepth - 1;
        }
        return countNodes2(root.right) + countNodes2(root.left) + 1;
    }
}
