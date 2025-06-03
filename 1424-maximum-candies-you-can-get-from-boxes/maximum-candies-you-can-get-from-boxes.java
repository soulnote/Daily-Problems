public class Solution {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] opened = new boolean[n];
        boolean[] seen = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            queue.offer(box);
            seen[box] = true;
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();

            if (status[box]==0) {
                if (!hasKey[box]) continue; // Skip closed box if no key
                status[box] = 1;            // Open it if we now have key
            }

            if (opened[box]) continue;
            opened[box] = true;

            totalCandies += candies[box];

            // Add contained boxes
            for (int contained : containedBoxes[box]) {
                if (!seen[contained]) {
                    queue.offer(contained);
                    seen[contained] = true;
                }
            }

            // Collect keys and enqueue any box for which we now have a key
            for (int key : keys[box]) {
                hasKey[key] = true;
                if (seen[key]) {
                    queue.offer(key);
                }
            }
        }

        return totalCandies;
    }
}
