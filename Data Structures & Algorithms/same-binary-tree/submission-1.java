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
    boolean isSame = true;

    private void check(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return;
        }

        if (n1 == null || n2 == null || n1.val != n2.val) {
            isSame = false;
            return;
        }

        check(n1.left, n2.left);
        check(n1.right, n2.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p, q);
        return isSame;    
    }
}
