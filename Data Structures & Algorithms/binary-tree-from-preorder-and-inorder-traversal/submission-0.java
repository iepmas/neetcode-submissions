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
    int preIndex = 0;
    private TreeNode traversal(int[] preorder, int[] inorder, int l, int r) {
        if (l > r) {
            return null;
        }

        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = -1;

        // find left and right boundary
        for (int i = l; i <= r; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        root.left = traversal(preorder, inorder, l, rootIndex - 1);
        root.right = traversal(preorder, inorder, rootIndex + 1, r);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traversal(preorder, inorder, 0, preorder.length - 1);
    }
}
