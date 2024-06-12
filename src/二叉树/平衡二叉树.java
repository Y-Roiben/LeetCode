package 二叉树;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return getHigh(root) != -1;
    }

    public int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
