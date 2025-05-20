/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = new ArrayList<>();
        ArrayList<TreeNode> listQ = new ArrayList<>();
        helper(root,p,listP);
        helper(root,q,listQ);
       
        int n = Math.min(listP.size(),listQ.size());
        int i=0;
        for(;i<n;i++){
            if(listP.get(i)==null || listP.get(i).val!=listQ.get(i).val){
                break;
            }
        }
        return listP.get(i-1);
    }
    public void helper(TreeNode root, TreeNode p,ArrayList<TreeNode> list){
        if(root==null)return ;
        list.add(root);
        if(root.val==p.val)return;
        if(root.val<p.val){
            helper(root.right,p,list);
        }
        else helper(root.left,p,list);
        
    }
}