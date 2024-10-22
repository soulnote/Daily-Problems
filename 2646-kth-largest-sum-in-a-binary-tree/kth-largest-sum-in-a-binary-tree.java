/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            public int compare(Long a, Long b) {
                return b.compareTo(a);
            }
        });

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            long sum = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            // System.out.println(sum);
            pq.add(sum);
        }
        long ans = -1;
        if(pq.size()<k)return ans;
        while (k-- >0) {
            ans = pq.poll();
        }
        return ans;
    }
}