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
        balanced(root);
        return flag;
    }

    public int balanced(TreeNode root){
        if(root==null)return 0;
        int lefttree = balanced(root.left);
        int righttree = balanced(root.right);
        if(Math.abs(lefttree-righttree)>1) {
            flag = false;
        }
        return Math.max(lefttree,righttree)+1;
    }
}