class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Step 1: Find the maximum number of bananas in any pile
        int maxPile = 0;
        for (int bananas : piles) {
            maxPile = Math.max(maxPile, bananas);
        }

        // Step 2: Use binary search to find the minimum eating speed (k)
        int left = 1;
        int right = maxPile;
        int result = maxPile; // Initialize result with the maximum possible speed

        while (left <= right) {
            int midSpeed = left + (right - left) / 2;

            // Step 3: Calculate total hours needed to eat all bananas at speed midSpeed
            long totalHours = 0;
            for (int bananas : piles) {
                // Use ceiling division: (bananas + midSpeed - 1) / midSpeed
                totalHours += (bananas + midSpeed - 1) / midSpeed;
            }

            // Step 4: Check if Koko can finish eating in h hours with midSpeed
            if (totalHours <= h) {
                result = midSpeed;  // midSpeed is a valid option, try to find a smaller one
                right = midSpeed - 1;
            } else {
                left = midSpeed + 1; // midSpeed too small, increase it
            }
        }

        return result;
    }
}
