/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int globalMax = Integer.MIN_VALUE;
    private int getCurrDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int l = getCurrDiameter(node.left);
        int r = getCurrDiameter(node.right);
        globalMax = Math.max(globalMax, l + r);
        return Math.max(l, r) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getCurrDiameter(root);
        return globalMax;
    }
}
