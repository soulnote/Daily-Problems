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
    int ans =0;
    public int diameterOfBinaryTree(TreeNode root) {
        int height =  solve(root);
        return ans;
    }
    int solve(TreeNode root){
        if(root==null)return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        ans = Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }
}