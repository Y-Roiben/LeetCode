package 二叉树;


import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node2> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node2> _children) {
        val = _val;
        children = _children;
    }
}

public class N叉数前序遍历 {
    public List<Integer> preorder(Node2 root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        pre(root, res);
        return res;
    }

    public void pre(Node2 root, List<Integer> res) {
        res.add(root.val);
        for (Node2 child : root.children) {
            pre(child, res);
        }
    }
}
