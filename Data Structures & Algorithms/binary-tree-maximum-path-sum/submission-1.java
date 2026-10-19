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
    int ret = Integer.MIN_VALUE;

    private int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traversal(node.left);
        int right = traversal(node.right);


        int sumLeft = node.val + Math.max(left, 0);
        int sumRight = node.val + Math.max(right, 0);
        int sum = sumLeft + sumRight - node.val;
        ret = Math.max(ret, sum);
        return Math.max(sumLeft, sumRight);
    }
    public int maxPathSum(TreeNode root) {
        // for each node, we must consider the maximum path which includes itself.
        // that is what we must return
        // we can consider the left and right nodes to see what the maximum sum is for them and if they'd add to our current node or not.
        traversal(root);
        return ret;
    }
}
