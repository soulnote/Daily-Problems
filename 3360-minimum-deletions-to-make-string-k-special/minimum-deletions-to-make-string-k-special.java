class Solution  {
    public int minimumDeletions(String word, int k) {
        // Get frequency of each character
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Collect non-zero frequencies
        List<Integer> frequencies = new ArrayList<>();
        for (int count : freq) {
            if (count > 0) {
                frequencies.add(count);
            }
        }
        
        // Sort frequencies in ascending order
        Collections.sort(frequencies);
        
        int n = frequencies.size();
        int minDeletions = Integer.MAX_VALUE;
        
        // Try each frequency as the baseline
        for (int i = 0; i < n; i++) {
            int deletions = 0;
            int baseline = frequencies.get(i);
            
            // For frequencies below baseline, delete all occurrences
            for (int j = 0; j < i; j++) {
                deletions += frequencies.get(j);
            }
            
            // For frequencies above baseline, reduce to baseline + k if needed
            for (int j = i + 1; j < n; j++) {
                if (frequencies.get(j) > baseline + k) {
                    deletions += frequencies.get(j) - (baseline + k);
                }
            }
            
            minDeletions = Math.min(minDeletions, deletions);
        }
        
        return minDeletions == Integer.MAX_VALUE ? 0 : minDeletions;
    }
}