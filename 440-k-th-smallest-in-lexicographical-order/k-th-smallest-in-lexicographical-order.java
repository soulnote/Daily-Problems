class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;  // We treat the first number as the "0-th" number
        
        while (k > 0) {
            long steps = calcSteps(n, curr, curr + 1);
            if (steps <= k) {
                // We skip to the next prefix
                curr++;
                k -= steps;
            } else {
                // Go deeper into the current prefix
                curr *= 10;
                k--;
            }
        }
        
        return curr;
    }
    
    // Calculate how many numbers are there between curr and next in the range [1, n]
    private long calcSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}