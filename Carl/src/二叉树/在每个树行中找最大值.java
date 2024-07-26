package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size>0){
                TreeNode poll = queue.poll();
                if (poll.val > max){
                    max = poll.val;
                }
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                size--;
            }
            res.add(max);
        }
        return res;

    }
}
