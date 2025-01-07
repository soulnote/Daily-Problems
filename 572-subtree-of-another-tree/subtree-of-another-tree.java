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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)return true;
        if(root==null || subRoot==null)return false;
        boolean isSame= isSameTree(root, subRoot);
        if(isSame){
            return true;
        }
        return isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);
    }
    public boolean isSameTree(TreeNode tree1, TreeNode tree2){
        if(tree1==null && tree2==null)return true;
        if(tree1==null || tree2==null)return false;
        return tree1.val==tree2.val && isSameTree(tree1.left, tree2.left)&& isSameTree(tree1.right, tree2.right);
    }
}

// 3,4,5,1,2,8