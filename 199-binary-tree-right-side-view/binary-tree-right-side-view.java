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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans; 
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            if(q.size()>=1)ans.add(q.peek().val);
            for(int i=0;i<size;i++){
                TreeNode t = q.poll();
                if(t==null)continue;
                // list.add(t.val);
                if(t.right!=null)q.offer(t.right);
                if(t.left!=null)q.offer(t.left);
            }
            // ans.add(list.getLast());
        }
        return ans;
    }
}