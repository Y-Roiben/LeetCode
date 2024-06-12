package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class 二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        paths(root, new ArrayList<>(), res);
        return res;
    }

    public void paths(TreeNode tree, List<Integer> path, List<String> res){
        path.add(tree.val);
        if (tree.left == null && tree.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                stringBuilder.append(path.get(i));
                stringBuilder.append("->");
            }
            stringBuilder.append(path.getLast());
            res.add(stringBuilder.toString());
            return;
        }
        if (tree.left != null) {
            paths(tree.left, path, res);
            path.removeLast();  // 这里是关键，因为path是引用传递，所以要回溯
        }
        if (tree.right != null) {
            paths(tree.right, path, res);
            path.removeLast();
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        deal(root, "", res);
        return res;
    }

    public void deal(TreeNode node, String path, List<String> res){
        if (node == null){
            return;
        }

        // 不推荐使用+拼接字符串，因为每次拼接都会生成一个新的字符串对象，会消耗大量的内存, 速度较慢
        if (node.left == null && node.right == null){
            res.add(new StringBuilder(path).append(node.val).toString());
            return;
        }
        path = new StringBuilder(path).append(node.val).append("->").toString();
        deal(node.left, path, res);
        deal(node.right, path, res);
    }

}
