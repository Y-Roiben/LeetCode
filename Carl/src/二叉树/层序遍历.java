package 二叉树;

import java.util.*;

public class 层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }


    // 倒叙层序输出
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.addFirst(list);
        }

        return res;
    }




}
