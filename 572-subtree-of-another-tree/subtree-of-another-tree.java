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
    boolean ans =false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;
        if(root.val==subRoot.val){
            ans = ans|isSameTree(root,subRoot);
        }
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        return left|right|ans;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.val==q.val && isSameTree(p.left,q.left)&&isSameTree(p.right,q.right))return true;
        else return false;
    }
}