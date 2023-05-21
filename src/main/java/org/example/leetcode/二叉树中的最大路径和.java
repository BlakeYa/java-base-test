package org.example.leetcode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/comments/
public class 二叉树中的最大路径和 {

   static int maxPathSum = Integer.MIN_VALUE; // 定义一个最小值，因为有可能只有一个节点，这个节点是一个负数
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode( 2);
        node.right = new TreeNode( 3);

        maxPathSum(node);

        System.out.println(maxPathSum);
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null)  return 0;
        dfs(root);
        return maxPathSum;
    }

    public static int dfs(TreeNode root){

        if (root == null)  return 0;
        // 采用后序遍历方式找出最大的节点和
        int left = Math.max(0,maxPathSum(root.left));
        int right = Math.max(0,maxPathSum(root.right));
        maxPathSum = Math.max(maxPathSum, root.val + left + right);
        return root.val + Math.max(left,right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}