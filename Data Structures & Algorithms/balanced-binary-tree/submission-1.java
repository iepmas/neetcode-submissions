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
    boolean isBalanced = true;

    private int subtreeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = subtreeHeight(node.left) + 1;
        int r = subtreeHeight(node.right) + 1;

        if (Math.abs(l - r) > 1) {
            isBalanced = false;
        }
        return Math.max(l, r);
    }
    public boolean isBalanced(TreeNode root) {
        subtreeHeight(root);
        return isBalanced;
    }
}
