class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int t = 0; // Number of operations
        
        // Operations 1, 2, 3, ...
        // We stop when the shift s >= n because there's no way to match 
        // a prefix of length n-s > 0 with a suffix of length n-s.
        // We only check for shifts s = k, 2k, 3k, ...
        for (int s = k; s < n; s += k) {
            t++; // Increment operation count before check
            int remaining_length = n - s;

            // Check if the prefix of length (n - s) matches the suffix of length (n - s)
            // Prefix: word.substring(0, remaining_length)
            // Suffix: word.substring(s)
            
            boolean isMatch = true;
            for (int i = 0; i < remaining_length; i++) {
                if (word.charAt(i) != word.charAt(s + i)) {
                    isMatch = false;
                    break;
                }
            }
            
            if (isMatch) {
                return t;
            }
        }
        
        // Agar n-1 shifts tak koi match nahi mila, toh final operation 
        // jisme string ya toh same ho jaati hai (if n is a multiple of k) 
        // ya sirf ek baar aur shift karna padta hai.
        // Jo bhi ho, hume n tak pahunchne ke liye operations return karne hain.
        // Total time = ceil(n / k)
        return (n + k - 1) / k; 
        // This is a common way to calculate ceil(n/k) for integer division.
    }
}