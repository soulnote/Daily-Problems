import java.util.List;
import java.util.ArrayList;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root,result);
        if (k > 0 && k <= result.size()) {
            return result.get(k - 1);
        }
        return -1;
    }
    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}