import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // Frequency array for each task
        int[] frequency = new int[26];
        for (char task : tasks) {
            frequency[task - 'A']++;
        }

        // Max heap for the task frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : frequency) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        int time = 0;  // Total time intervals
        Queue<Pair<Integer, Integer>> waitQueue = new LinkedList<>();  // Wait queue for cooldown tasks

        while (!maxHeap.isEmpty() || !waitQueue.isEmpty()) {
            time++;  // Increment time at each interval

            if (!maxHeap.isEmpty()) {
                int currentTaskCount = maxHeap.poll() - 1;  // Process one task
                if (currentTaskCount > 0) {
                    waitQueue.add(new Pair<>(currentTaskCount, time + n));  // Add to wait queue if still needed
                }
            }

            // Check if any task in waitQueue can be re-added to maxHeap
            if (!waitQueue.isEmpty() && waitQueue.peek().getValue() == time) {
                maxHeap.add(waitQueue.poll().getKey());
            }
        }

        return time;  // Return the total time taken
    }
}
