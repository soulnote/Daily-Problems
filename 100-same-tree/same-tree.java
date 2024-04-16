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
    boolean ans = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
      solve(p,q);
      return ans;
    }
    public void solve(TreeNode p, TreeNode q){
        if(p==null&& q==null){
            return;
        }
        if(p==null || q==null){
            ans = false;
            return ;
        }
     
        if(p.val!=q.val)ans = false;
        solve(p.left,q.left);
        solve(p.right,q.right);
    }
}