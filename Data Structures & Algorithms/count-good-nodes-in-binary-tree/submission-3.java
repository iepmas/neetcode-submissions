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

    private void traversal(TreeNode node, int prevMax) {
        if (node == null) {
            return;
        }

        if (node.val >= prevMax) {
            ret++;
        }

        if (node.left != null) {
            traversal(node.left, Math.max(node.val, prevMax));
        }

        if (node.right != null) {
            traversal(node.right, Math.max(node.val, prevMax));
        }
    }
    public int goodNodes(TreeNode root) {
        traversal(root, root.val);
        return ret;
    }
}
