package swordoffer.tree;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * Solution 递归交换左右子树
 */
public class MirrorTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
        if (root.left == null && root.right == null) {
            return;
        } else if (root.left == null) {
            root.left = root.right;
            root.right = null;
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
        } else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
}
