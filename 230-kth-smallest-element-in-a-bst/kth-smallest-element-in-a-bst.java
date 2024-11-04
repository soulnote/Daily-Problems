class Solution {
    private int count = 0, ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;  // Reset count before each call
        ans = -1;   // Reset ans before each call
        inorderTraversal(root, k);
        return ans;
    }

    private void inorderTraversal(TreeNode root, int k) {
        if (root == null) return;

        inorderTraversal(root.left, k);
        
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        
        inorderTraversal(root.right, k);
    }
}
