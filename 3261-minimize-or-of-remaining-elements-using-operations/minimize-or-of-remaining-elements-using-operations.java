class Solution {
    public int minOrAfterOperations(int[] nums, int k) {
        int result = 0; // Initialize the result to 0

        // Iterate over each bit position from 30 down to 0
        for (int bit = 30; bit >= 0; bit--) {
            int segmentCount = 0; // Count of valid segments
            int currentMask = (1 << 30) - 1; // Initialize with all bits set
            int target = result | ((1 << bit) - 1); // Target value for the current bit

            // Check if the current bit can be set in the result
            for (int num : nums) {
                currentMask &= num; // Perform bitwise AND with the current number
                if ((currentMask | target) == target) {
                    segmentCount++; // Increment segment count
                    currentMask = (1 << 30) - 1; // Reset the mask for the next segment
                }
            }

            // If the number of segments is greater than 'k', set the current bit in the result
            if (nums.length - segmentCount > k) {
                result |= (1 << bit);
            }
        }

        return result;
    }
}