class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],
        // b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { nums[i], i });
        }

        while (k-- > 0) {
            int[] smallest = pq.poll();
            smallest[0] = smallest[0] * multiplier;
            pq.add(smallest);
        }
        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            nums[e[1]] = e[0];
        }
        return nums;
    }
}