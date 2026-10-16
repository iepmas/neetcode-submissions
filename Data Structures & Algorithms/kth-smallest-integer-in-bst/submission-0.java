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
    int ret = 0;
    int counter = 0;
    
    private void traversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        traversal(node.left, k);

        // process node.
        counter++;
        if (counter == k) {
            ret = node.val;
        }

        traversal(node.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return ret;
    }
}
