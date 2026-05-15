class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int numberOfPermutations(int n, int[][] requirements) {
        // Create array to store requirements: req[end_index] = required inversion count
        int[] requiredInv = new int[n];
        Arrays.fill(requiredInv, -1);
        
        for (int[] req : requirements) {
            int endIdx = req[0];
            int cnt = req[1];
            requiredInv[endIdx] = cnt;
        }
        
        // memo[pos][inv] = number of ways
        // pos = how many elements placed so far (0 to n)
        // inv = inversion count in current prefix
        // We use Long to store -1 for uncomputed states
        Long[][] memo = new Long[n + 1][401]; // max inversions <= 400
        
        return dfs(0, 0, n, requiredInv, memo);
    }
    
    private int dfs(int pos, int inv, int n, int[] requiredInv, Long[][] memo) {
        // pos = number of elements already placed
        // This means we're about to place element at index 'pos'
        // Current prefix length = pos
        
        // Check if current prefix meets requirement
        if (pos > 0 && requiredInv[pos - 1] != -1 && requiredInv[pos - 1] != inv) {
            return 0;
        }
        
        // If we've placed all n elements
        if (pos == n) {
            return 1;
        }
        
        // Check memoization
        if (memo[pos][inv] != null) {
            return memo[pos][inv].intValue();
        }
        
        long total = 0;
        
        // We have placed 'pos' elements
        // The remaining numbers are: some set of 'pos' numbers already used
        // But in this DP approach, we don't track exactly which numbers are used
        // Instead, we think in terms of building permutation incrementally:
        // At step pos (meaning we're adding the (pos+1)th element),
        // we can insert the new number (which will be 'pos' itself if we think in terms of
        // constructing permutation of 0..n-1 by inserting numbers in increasing order)
        
        // Actually, standard approach: Build permutation by inserting numbers 0,1,2,...,n-1
        // At step i (0-indexed), we have placed numbers 0..i-1, and we're inserting number i
        // into any of the i+1 positions (0 to i from left)
        // Inserting at position k adds k inversions
        
        // So at step pos (i = pos), we have i+1 possible insertion positions
        // Wait, careful: pos here is count of elements already placed
        // So we're about to place number 'pos' (0-indexed) because we're placing in order
        
        // Number of insertion positions = pos + 1 (positions 0 to pos)
        for (int insertPos = 0; insertPos <= pos; insertPos++) {
            int newInv = inv + insertPos;
            
            // Prune: if newInv exceeds 400, skip (as per constraints)
            if (newInv > 400) continue;
            
            // Check if this state is promising
            // We can add early pruning: if newInv > any future required inversion count
            // But let's keep it simple for now
            
            total += dfs(pos + 1, newInv, n, requiredInv, memo);
            if (total >= MOD) total -= MOD;
        }
        
        memo[pos][inv] = total;
        return (int) total;
    }
}