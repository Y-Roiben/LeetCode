package 二叉树;

import java.util.Queue;
import java.util.LinkedList;

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class 填充每个节点的下一个右侧节点指针 {
    public Node1 connect(Node1 root) {
        if (root == null) return null;
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Node1 poll = queue.poll();
                if (i == size - 1) {
                    poll.next = null;
                }else {
                    poll.next = queue.peek();
                }
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return root;
    }
}
