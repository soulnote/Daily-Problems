class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int arrayLength = nums.length;
        int lowerBound = 0, upperBound = nums[arrayLength - 1] - nums[0];

        while (lowerBound < upperBound) {
            int middle = lowerBound + (upperBound - lowerBound) / 2;
            // If enough pairs are found, try a smaller difference
            // Otherwise, try a larger difference
            if (countValidPairs(nums, middle) >= p) {
                upperBound = middle;
            } else {
                lowerBound = middle + 1;
            }
        }
        return lowerBound;
    }
    // Calculate the count of valid pairs using a greedy strategy
    private int countValidPairs(int[] nums, int threshold) {
        int position = 0, pairCount = 0;
        while (position < nums.length - 1) {
            // If a valid pair is found, skip both elements
            if (nums[position + 1] - nums[position] <= threshold) {
                pairCount++;
                position++;
            }
            position++;
        }
        return pairCount;
    }
}