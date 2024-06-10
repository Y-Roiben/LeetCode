package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 统一迭代遍历 {
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty() ){
            cur = stack.pop();
            if (cur != null){
                if (cur.right != null) stack.push(cur.right);
                stack.push(cur);
                stack.push(null);
                if (cur.left != null) stack.push(cur.left);
            }else {
                cur = stack.pop();
                list.add(cur.val);
            }
        }

        return list;
    }
}
