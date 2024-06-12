package 二叉树;

public class 另一颗子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot!= null) return false;
        if (root == null) return true;
        if (subRoot == null) return true;
        if (compare(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean compare(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return compare(root1.left, root2.left) && compare(root1.right, root2.right);
    }
}
