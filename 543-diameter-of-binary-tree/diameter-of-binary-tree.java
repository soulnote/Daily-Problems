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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depthHeight(root);
        return diameter;
    }
    public int depthHeight(TreeNode root){
        if(root==null)return 0;
        int left = depthHeight(root.left);
        int right = depthHeight(root.right);
        diameter = Math.max(diameter, left+right);
        int depth = Math.max(left, right)+1;
        return depth;
    }
}