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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long minVal, long maxVal) {
        if (node == null) {
            return true;
        }

        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }

        boolean isLeftSubtreeValid = isValidBSTHelper(node.left, minVal, node.val);
        if (!isLeftSubtreeValid) {
            return false;
        }

        boolean isRightSubtreeValid = isValidBSTHelper(node.right, node.val, maxVal);
        if (!isRightSubtreeValid) {
            return false;
        }

        return true;
    }
}
