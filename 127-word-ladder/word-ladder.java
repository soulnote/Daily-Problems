class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to a HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Queue for BFS: each element is a pair (word, steps)
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Nodes at current BFS level

            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return steps;

                // Try all possible one-letter transformations
                char[] wordChars = word.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        wordChars[j] = ch;
                        String newWord = new String(wordChars);

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Mark visited
                        }
                    }
                    wordChars[j] = originalChar; // Restore original char
                }
            }

            steps++; // Move to next BFS level
        }

        return 0; // No path found
    }
}
