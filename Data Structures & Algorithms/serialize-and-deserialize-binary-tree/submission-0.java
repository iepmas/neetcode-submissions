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

public class Codec {
    ArrayList<String> serialized;

    int i = 0;
    String[] deserialized;

    private void sTraversal(TreeNode node) {
        if (node == null) {
            serialized.add("N");
            return;
        }
        serialized.add(Integer.toString(node.val));
        sTraversal(node.left);
        sTraversal(node.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serialized = new ArrayList<>();
        sTraversal(root);
        String ret = serialized.stream().map(String::valueOf).collect(Collectors.joining(","));
        return ret;
    }

    private TreeNode dTraversal() {
        if (deserialized[i].equals("N")) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(deserialized[i]));
        i++;

        node.left = dTraversal();
        node.right = dTraversal();

        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        deserialized = data.split(",");
        i = 0;
        return dTraversal();
    }
}
