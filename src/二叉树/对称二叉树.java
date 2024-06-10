package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;


        // 翻转二叉树
        TreeNode treeRoot = root.left;
        TreeNode treeNode = invertTree(treeRoot);


        return compare(treeNode, root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public boolean compare(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return compare(root1.left, root2.left) && compare(root1.right, root2.right);
    }

}
