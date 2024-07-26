package 二叉树;

public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder);
    }

    public TreeNode build(int[] inorder, int[] postorder){
        if (inorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        if (inorder.length == 1) return root;  // 只有一个节点

        int index = 0;  // 根节点在中序遍历中的位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int[] leftInorder = new int[index];
        int[] leftPostorder = new int[index];
        // 构造左子树
        for (int i = 0; i < index; i++) {
            leftInorder[i] = inorder[i];
            leftPostorder[i] = postorder[i];
        }
        root.left = build(leftInorder, leftPostorder);
        int rightLen = inorder.length - index - 1;
        int[] rightInorder = new int[rightLen];
        int[] rightPostorder = new int[rightLen];
        // 构造右子树
        for (int i = 0; i < rightLen; i++) {
            rightInorder[i] = inorder[index + i + 1];
            rightPostorder[i] = postorder[index + i];
        }
        root.right = build(rightInorder, rightPostorder);
        return root;
    }

    // 使用引用数据类型，减少数组的拷贝, 节省时间空间开销
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return build2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    // inorder: 中序遍历数组 postorder: 后序遍历数组
    public TreeNode build2 (int[] inorder, int inStart, int inEnd,
                            int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        if (inStart == inEnd) return root;  // 只有一个节点
        int index = 0;  // 根节点在中序遍历中的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftLen = index - inStart;
        root.left = build2(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftLen - 1);
        root.right = build2(inorder, index + 1, inEnd,
                postorder, postStart + leftLen, postEnd - 1);
        return root;
    }

}
