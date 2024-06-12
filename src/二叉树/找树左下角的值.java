package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值 {

    private int maxDepth = 0;
    private int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) res = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;

    }

    public int findBottomLeftValue1(TreeNode root) {
        // 深度优先搜索策略
        dfs(root, 1);
        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        // 叶子节点
        if (root.left == null && root.right == null){
            if (depth > maxDepth) {
                maxDepth = depth;
                res = root.val;
            }
        }
        /*
        * depth += 1
        * dfs(root.left, depth);
        * depth -=1  回溯
        *
        * */
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}