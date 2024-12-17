class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            arr[ch]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(new int[]{i, arr[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = new int[]{-1, 0};

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int count = node[1];
            char ch = (char) (node[0] + 'a');

            if (prev[1] > 0 && prev[0] == node[0]) {
                if (pq.isEmpty()) {
                    break;
                }
                int[] next = pq.poll();
                char nextCh = (char) (next[0] + 'a');
                sb.append(nextCh);
                next[1]--;
                if (next[1] > 0) {
                    pq.add(next);
                }
                pq.add(node);
                prev = new int[]{next[0], 0};  // Reset prev
                continue;
            }

            int numToAdd = Math.min(count, repeatLimit);
            for (int i = 0; i < numToAdd; i++) {
                sb.append(ch);
            }

            if (count - numToAdd > 0) {
                pq.add(new int[]{node[0], count - numToAdd});
            }
            prev = new int[]{node[0], numToAdd};
        }

        return sb.toString();
    }
}
