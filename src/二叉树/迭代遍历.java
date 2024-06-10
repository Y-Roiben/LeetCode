package 二叉树;

import java.util.*;

public class 迭代遍历 {

    // 递归模拟前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return list;
    }


    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
        }
        Collections.reverse(list);

        return list;

    }


    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty() ) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }

        }
        return list;
    }






}
