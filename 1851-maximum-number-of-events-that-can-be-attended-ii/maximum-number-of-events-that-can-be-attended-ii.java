class Solution {
    int[][] memo;
    int[][] events;
    int n;

    public int maxValue(int[][] events, int k) {
        // Sort events by start time. If start times are same, sort by end time (optional but good practice)
        // or just keep by start time for this problem.
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        this.events = events;
        this.n = events.length;
        memo = new int[n][k + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dp(0, k);
    }

    int dp(int i, int k) {
        if (i == n || k == 0) return 0;
        if (memo[i][k] != -1) return memo[i][k];

        // Option 1: Skip this event
        int notTake = dp(i + 1, k);

        // Option 2: Take this event
        // The findNext needs to find the first event whose start time is
        // strictly greater than events[i][1] (the end time of the current event).
        int nextIdx = findNext(i + 1, events[i][1]); // Start search from i+1
        int take = events[i][2] + dp(nextIdx, k - 1);

        return memo[i][k] = Math.max(take, notTake);
    }

    // Binary search to find the next non-overlapping event
    // Finds the first event whose start time is STRICTLY GREATER THAN targetEnd.
    // If no such event is found, returns 'n'.
    int findNext(int left, int targetEnd) {
        int low = left;
        int high = n; // High is 'n' (exclusive upper bound of search space)

        while (low < high) { // Loop as long as there is a search space
            int mid = low + (high - low) / 2;

            if (events[mid][0] > targetEnd) { // If this event starts strictly after targetEnd, it's a candidate
                high = mid; // This 'mid' is a potential answer, try to find an even earlier one
            } else { // This event overlaps or starts too early (<= targetEnd)
                low = mid + 1; // Move 'low' to the right to look for a non-overlapping event
            }
        }
        return low; // At the end of the loop, 'low' will be the first index
                    // where events[low][0] > targetEnd, or 'n' if no such event exists.
    }
}