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
    public int sumOfLeftLeaves(TreeNode root) {
        return leavesSum(root,false);
    }
    public int leavesSum(TreeNode node,boolean isLeft){
        if(node==null) return 0;
        if(node.left==null && node.right==null){
            if(isLeft)return node.val;
            else return 0;
        }
        int leftsum = leavesSum(node.left,true);
        int rightsum = leavesSum(node.right,false);
        return leftsum+rightsum;
    }
}