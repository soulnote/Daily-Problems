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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> pmap = new HashMap<>();
        findmap(root, null, pmap);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int d = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(d==k)break;
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                if(pmap.get(node)!=null && !visited.contains(pmap.get(node))){
                    q.add(pmap.get(node));
                    visited.add(pmap.get(node));
                }
            }
            d++;
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
    public void findmap(TreeNode node, TreeNode parent, HashMap<TreeNode, TreeNode> pmap){
        if(node==null)return;
        pmap.put(node, parent);
        if(node.left!=null){
            findmap(node.left, node, pmap);
        }
        if(node.right!=null){
            findmap(node.right, node, pmap);
        }
    }
}