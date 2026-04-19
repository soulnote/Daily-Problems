import java.util.*;

class Solution {
    public long countGoodIntegersOnPath(long l, long r, String directions) {
        // Step 1: Get path indices from directions
        int[] pathIndices = getPathIndices(directions);
        
        // Step 2: Convert l and r to 16-digit strings with leading zeros
        String lStr = String.format("%016d", l);
        String rStr = String.format("%016d", r);
        
        // Step 3: DP memoization - [idx][tightLow][tightHigh][prevDigit][pathPos]
        Long[][][][][] memo = new Long[17][2][2][11][8];
        
        // Step 4: Run digit DP
        return dfs(0, true, true, 10, 0, lStr, rStr, pathIndices, memo);
    }
    
    private int[] getPathIndices(String directions) {
        // Calculate positions visited along the path
        List<Integer> positions = new ArrayList<>();
        positions.add(0); // Starting at (0,0) -> index 0
        
        int row = 0, col = 0;
        for (char move : directions.toCharArray()) {
            if (move == 'D') {
                row++;
            } else { // 'R'
                col++;
            }
            positions.add(row * 4 + col);
        }
        
        // Convert to int array (should have 7 positions: start + 6 moves)
        int[] indices = new int[positions.size()];
        for (int i = 0; i < positions.size(); i++) {
            indices[i] = positions.get(i);
        }
        return indices;
    }
    
    private long dfs(int idx, boolean tightLow, boolean tightHigh, 
                     int prevDigit, int pathPos,
                     String lStr, String rStr, int[] pathIndices,
                     Long[][][][][] memo) {
        // Base case: processed all 16 digits
        if (idx == 16) {
            // Valid only if we've placed all 7 path digits
            return pathPos == 7 ? 1 : 0;
        }
        
        // Convert booleans to ints for memoization
        int tLow = tightLow ? 1 : 0;
        int tHigh = tightHigh ? 1 : 0;
        
        // Check memo cache
        if (memo[idx][tLow][tHigh][prevDigit][pathPos] != null) {
            return memo[idx][tLow][tHigh][prevDigit][pathPos];
        }
        
        // Determine the range of digits we can place at this position
        int lowDigit = tightLow ? (lStr.charAt(idx) - '0') : 0;
        int highDigit = tightHigh ? (rStr.charAt(idx) - '0') : 9;
        
        long total = 0;
        
        // Try all possible digits
        for (int dig = lowDigit; dig <= highDigit; dig++) {
            boolean newTightLow = tightLow && (dig == lowDigit);
            boolean newTightHigh = tightHigh && (dig == highDigit);
            
            // Check if this digit position is on our path
            if (pathPos < 7 && idx == pathIndices[pathPos]) {
                // This digit is the next in the path sequence
                // Check non-decreasing condition
                if (prevDigit == 10 || dig >= prevDigit) {
                    total += dfs(idx + 1, newTightLow, newTightHigh, 
                                dig, pathPos + 1,
                                lStr, rStr, pathIndices, memo);
                }
            } else {
                // This digit is not on the path
                total += dfs(idx + 1, newTightLow, newTightHigh, 
                            prevDigit, pathPos,
                            lStr, rStr, pathIndices, memo);
            }
        }
        
        // Store in memo and return
        memo[idx][tLow][tHigh][prevDigit][pathPos] = total;
        return total;
    }
}