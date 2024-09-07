package 二叉树;

public class 二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        int treeVal;
        TreeNode temp = root;
        while (temp != null){
            treeVal = temp.val;
            if (val == treeVal){
                return temp;
            }else if (val > treeVal){
                temp = temp.right;
            }else {
                temp = temp.left;
            }
        }
        return null;
    }
}
