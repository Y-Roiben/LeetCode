package 二叉树;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 前序遍历 {


    public List preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traversal(root, list);

        return list;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }


}
