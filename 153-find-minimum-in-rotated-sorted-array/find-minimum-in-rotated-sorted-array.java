class Solution {
    public int findMin(int[] nums) {
        // Initialize search space
        int left = 0;
        int right = nums.length - 1;

        // Initialize minimum to a large value
        int minValue = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Case 1: Left half is sorted
            if (nums[mid] >= nums[left]) {
                // The smallest value in this sorted range could be nums[left]
                minValue = Math.min(minValue, nums[left]);
                // Move to the right half (excluding current left part)
                left = mid + 1;
            } else {
                // Case 2: Rotation happened, and mid is smaller than left
                // So the smallest could be at mid or in left half
                minValue = Math.min(minValue, nums[mid]);
                right = mid - 1;
            }
        }

        return minValue;
    }
}