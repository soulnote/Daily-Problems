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
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        isPath(root, p, list1);
        isPath(root, q, list2);
        int idx = 0;
        int n = Math.min(list1.size(), list2.size());
        while(idx<n && list1.get(idx)==list2.get(idx)){
            idx++;
        }
        return list1.get(idx-1);

    }
    boolean isPath(TreeNode root, TreeNode x, List<TreeNode> list){
        if(root==null)return false;
        list.add(root);
        if(root.val == x.val){
            return true;
        }
        boolean left = isPath(root.left, x, list);
        boolean right = isPath(root.right, x, list);
        if(left || right) return true;
        list.remove(list.size()-1);
        return false;
    }
}