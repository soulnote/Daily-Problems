class Solution {
    int n;
    int[][] memo;
    public int maxValue(int[][] events, int k) {
        n = events.length;
        Arrays.sort(events, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        memo = new int[n+1][k+1];
        for(int[] mem:memo) {
            Arrays.fill(mem, -1);
        }
        return backtrack(0, events, k);
    }

    int backtrack(int idx, int[][] events, int k) {
        if(idx >= n || k == 0) {
            return 0;
        }
        if(memo[idx][k] != -1) {
            return memo[idx][k];
        }

        int nextValidIdx = idx+1;

        while(nextValidIdx<n && events[nextValidIdx][0] <= events[idx][1]){
            nextValidIdx++;
        }

        // take this
        int take = events[idx][2] + backtrack(nextValidIdx, events, k-1);

        // don't take this
        int notTake = backtrack(idx+1, events, k);
        return memo[idx][k] = Math.max(take, notTake);
    }
}