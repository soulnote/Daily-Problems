class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // First, find connected components using the cut conditions
        // A cut happens when max of left side <= min of right side
        
        // Compute prefix maximums
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        
        // Compute suffix minimums
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        
        // Find where components are separated
        // A cut exists at position i if prefixMax[i] <= suffixMin[i + 1]
        // This means all elements left of i+1 are <= all elements right of i
        
        // Process each component
        int componentStart = 0;
        for (int i = 0; i < n; i++) {
            // If this is the end of a component (cut after i)
            if (i == n - 1 || prefixMax[i] <= suffixMin[i + 1]) {
                // Current component is from componentStart to i
                // Find maximum in this component
                int maxInComponent = prefixMax[i]; // Since prefixMax[i] is max up to i
                
                // Assign this maximum to all indices in the component
                for (int j = componentStart; j <= i; j++) {
                    ans[j] = maxInComponent;
                }
                
                // Start new component
                componentStart = i + 1;
            }
        }
        
        return ans;
    }
}