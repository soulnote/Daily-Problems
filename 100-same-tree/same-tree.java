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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        boolean isRootEquals = (p.val==q.val);
        boolean isLeftEquals = isSameTree(p.left,q.left);
        boolean isRightEquals = isSameTree(p.right,q.right);
        if(isRootEquals && isLeftEquals && isRightEquals)return true;
        else return false;
    }
}