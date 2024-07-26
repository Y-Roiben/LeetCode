package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curr;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0){
                curr = queue.poll();
                if (size == 1){
                    res.add(curr.val);
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                size--;
            }
        }
        return res;

    }
}
