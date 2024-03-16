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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int first = height(left);
        int second= height(right);
        int diff = Math.abs(first-second);
        if(diff<=1 && isBalanced(root.left) && isBalanced(root.right)) return true;
        return false;
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1+Math.max(l,r);
    }

}