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
        return p.val < q.val ? findCommonAncestor(root, p, q) : findCommonAncestor(root, q, p);
    }

 
    private TreeNode findCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // if p and q are in two different branches that means root is the common ancestor
        if (p.val <= root.val && root.val <= q.val) return root;

        // p and q are in the same branch so we just need to find if p (or q) is in the left or right branch
        return findCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
    }
}