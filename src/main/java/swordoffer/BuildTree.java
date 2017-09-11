package swordoffer;

import java.util.Stack;

/**
 * Created by louzh on 2017/6/19.
 */
public class BuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        //前序遍历节点
        static void printNodePre(TreeNode node) {
            if (node == null) return;
            System.out.println(node.val);
            printNodePre(node.left);
            printNodePre(node.right);

        }

        //中序遍历
        static void printNodeIn(TreeNode node) {
            if (node == null) return;
            printNodeIn(node.left);
            System.out.println(node.val);
            printNodeIn(node.right);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 4, 5, 6, 7};
        reOrderArray(array);
        for (int a : array) {
            System.out.print(a + ",");
        }
    }

    public static int JumpFloor(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int sum = 0;
        for (int i = 1; i < target; i++) {
            sum += JumpFloor(i);
        }
        return sum + 1;
    }

    public static void reOrderArray(int[] array) {
        if (array.length <= 1) return;
        int idx = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[idx - 1]) {
                array[idx++] = array[i];
            }
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length || pre.length == 0)
            return null;
        TreeNode root = buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public static TreeNode buildTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = buildTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = buildTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }

        return root;
    }

    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while (stack1.size() > 0) {
                int val = stack1.pop();
                stack2.push(val);
            }
            stack1.push(node);
            while (stack2.size() > 0) {
                int val = stack2.pop();
                stack1.push(val);
            }
        }

        public int pop() {
            return stack1.pop();
        }
    }
}
