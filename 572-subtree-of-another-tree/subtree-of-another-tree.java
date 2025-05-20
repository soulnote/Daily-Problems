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
    private String serialize(TreeNode node) {
        if (node == null) {
            return "N";
        }
        return "(" + node.val + "," + serialize(node.left) + "," + serialize(node.right) + ")";
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootSerialized = serialize(root);
        String subRootSerialized = serialize(subRoot);
        return rootSerialized.contains(subRootSerialized);
    }
}