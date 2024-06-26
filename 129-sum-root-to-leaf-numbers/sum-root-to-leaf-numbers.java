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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    public int helper(TreeNode root, int ans) {
        if(root==null)return 0;
        ans*=10;
        ans+=root.val;
        if(root.left==null && root.right==null){
            return ans;
        }
        int right = helper(root.right,ans);
        int left = helper(root.left,ans);
        return left+right;
    }
   
}