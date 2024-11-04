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
    private int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        height(root);
        return maxi;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;
        int left= Math.max(0 , height(root.left));  
        int right= Math.max(0 , height(root.right));
        maxi= Math.max(maxi, left + right + root.val);  
        return root.val + Math.max(left , right); 
    }
}