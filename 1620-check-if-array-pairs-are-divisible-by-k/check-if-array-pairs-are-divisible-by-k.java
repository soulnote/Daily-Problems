class Solution {
    public boolean canArrange(int[] arr, int k) {
        // Edge case: if the array is too small to form pairs
        if (arr.length <= 1) return false;

        // Array to store the frequency of remainders
        int[] remainderFrequency = new int[k];

        // Step 1: Calculate remainders and store frequency of each remainder
        for (int i = 0; i < arr.length; i++) {
            int remainder = ((arr[i] % k) + k) % k; // Ensure positive remainder
            remainderFrequency[remainder]++;
        }

        // Step 2: Check pairing condition for remainder 0
        // Elements with remainder 0 must be paired with each other, so their count must be even
        if (remainderFrequency[0] % 2 != 0) return false;

        // Step 3: Check pairing condition for other remainders
        // Pair elements with remainder i and remainder (k - i)
        for (int i = 1; i <= k / 2; i++) {
            if (remainderFrequency[i] != remainderFrequency[k - i]) return false;
        }

        // If all conditions are met, return true
        return true;
    }
}
