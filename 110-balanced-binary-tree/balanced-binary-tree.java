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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))return true;
        solve(root);
        return flag;
    }
    public int solve(TreeNode root){
        if(root==null)return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        if(Math.abs(right-left)>1){
            flag = false;
        }
        return Math.max(left,right)+1;
    }
}