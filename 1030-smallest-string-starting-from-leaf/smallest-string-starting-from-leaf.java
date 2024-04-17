class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    
    private String dfs(TreeNode node, String suffix) {
        if (node == null) return suffix;
        suffix = (char) ('a' + node.val) + suffix;
        if (node.left == null && node.right == null) return suffix;
        String left = dfs(node.left, suffix);
        String right = dfs(node.right, suffix);
        if (node.left == null || node.right == null)
            return node.left == null ? right : left;
        return left.compareTo(right) < 0 ? left : right;
    }
}
