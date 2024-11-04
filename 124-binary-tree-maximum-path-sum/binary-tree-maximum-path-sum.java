class Solution {
    private int maxi = Integer.MIN_VALUE; // Global variable to store maximum path sum
    
    public int maxPathSum(TreeNode root) {
        height(root); // Calculate maximum path sum
        return maxi;  // Return the maximum path sum found
    }

    // Function to calculate the maximum path sum for a subtree rooted at 'root'
    public int height(TreeNode root) {
        if(root == null) return 0; // Base case: if node is null, return 0
        
        // Recursively calculate maximum path sum for left and right subtrees
        int left = Math.max(0, height(root.left));  // Ignore if path sum is negative
        int right = Math.max(0, height(root.right)); // Ignore if path sum is negative
        
        // Update global maximum path sum (considering current node as the root of the path)
        maxi = Math.max(maxi, left + right + root.val);
        
        // Return the maximum path sum including the current node and one of its subtrees
        return root.val + Math.max(left, right);
    }
}
