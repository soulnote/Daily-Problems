class Solution {
    public boolean isBalanced(TreeNode root) {
        int[] ans = height(root);
        if(ans[1]==1) return true;
        return false;
    }

    int[] height(TreeNode root){
        //base case
        if(root==null) return new int[] {0,1};

        //recursive case
        int[] leftNode = height(root.left);
        int[] rightNode = height(root.right);

        int leftHeight = leftNode[0];
        int rightHeight = rightNode[0];
        int isLeftNodeBalanced = leftNode[1];
        int isRightNodeBalanced = rightNode[1];

        if(Math.abs(leftHeight-rightHeight)<=1 && isLeftNodeBalanced==1 && isRightNodeBalanced==1){
            return new int[] {1+Math.max(leftHeight,rightHeight), 1};
        }
        return new int[] {1+Math.max(leftHeight,rightHeight), 0};
    }
}