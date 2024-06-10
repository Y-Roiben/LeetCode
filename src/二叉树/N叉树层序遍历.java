package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, List<Node2> _children) {
        val = _val;
        children = _children;
    }
}

public class N叉树层序遍历 {
    public List<List<Integer>> levelOrder(Node2 root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                Node2 node = queue.poll();
                size--;
                list.add(node.val);
                if (node.children != null) queue.addAll(node.children);
            }
            res.add(list);
        }
        return res;
    }
}
