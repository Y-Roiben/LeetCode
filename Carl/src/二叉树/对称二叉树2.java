package 二叉树;

public class 对称二叉树2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return compare(root1.left, root2.right) && compare(root1.right, root2.left);
    }
}
