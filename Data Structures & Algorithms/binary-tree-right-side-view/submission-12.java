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
    List<Integer> ret = new ArrayList<>();
    int height;
    
    private void traversal(TreeNode node, int currHeight) {
        if (node == null) {
            return;
        }

        if (currHeight > height) {
            height = currHeight;
            ret.add(node.val);
        }

        if (node.right != null) {
            traversal(node.right, currHeight + 1);
        }

        if (node.left != null) {
            traversal(node.left, currHeight + 1);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        traversal(root, 1);
        return ret;
    }
}
