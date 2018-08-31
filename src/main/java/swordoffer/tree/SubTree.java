package swordoffer.tree;

import java.util.HashSet;
import java.util.Set;

public class SubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        Set<TreeNode> treeNodes = new HashSet<>();
        addNodeToSet(treeNodes, root1);
        for (TreeNode node : treeNodes) {
            if (checkNode(node, root2))
                return true;
        }
        return false;
    }

    private void addNodeToSet(Set<TreeNode> treeNodes, TreeNode root1) {
        if (root1 == null) return;
        if (root1.left != null) {
            addNodeToSet(treeNodes, root1.left);
        }
        if (root1.right != null) {
            addNodeToSet(treeNodes, root1.right);
        }
        if (root1.right == null && root1.left == null) {
            addNodeToSet(treeNodes, root1);
        }
    }

    public boolean checkNode(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root2 == null || root1 == null) {
            return false;
        } else {
            if (root1.val == root2.val) {
                return checkNode(root1.left, root2.left) && checkNode(root1.right, root2.right);
            } else {
                return false;
            }
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
