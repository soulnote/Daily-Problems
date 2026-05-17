class Solution {
    public boolean canJump(int[] nums) {
        // Memoization array: 0 = uncomputed, 1 = can reach end, -1 = cannot reach end
        int[] memo = new int[nums.length];
        return canJumpFromPosition(0, nums, memo);
    }
    
    private boolean canJumpFromPosition(int position, int[] nums, int[] memo) {
        // Base case: reached the last index
        if (position == nums.length - 1) {
            return true;
        }
        
        // Check if we've already computed this position
        if (memo[position] != 0) {
            return memo[position] == 1;
        }
        
        // Get the maximum jump length from current position
        int maxJump = nums[position];
        
        // Try all possible jump lengths from 1 to maxJump
        // We jump to the furthest positions first for optimization
        int furthestJump = Math.min(position + maxJump, nums.length - 1);
        
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums, memo)) {
                memo[position] = 1;
                return true;
            }
        }
        
        // If no jump leads to the end
        memo[position] = -1;
        return false;
    }
}