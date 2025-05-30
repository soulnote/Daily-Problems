class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList into a set for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordList);
        
        // If the endWord is not in wordList, there is no possible transformation
        if (!wordSet.contains(endWord)) return new ArrayList<>();

        // This map stores for each word, its parent words in shortest transformation path
        Map<String, List<String>> parents = new HashMap<>();

        // Current level in BFS, starting with beginWord
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);

        // Keeps track of visited nodes to prevent cycles and extra work
        Set<String> visited = new HashSet<>();

        // This flag tells us when we've found the endWord
        boolean found = false;

        // Perform BFS to build the parent map
        while (!currentLevel.isEmpty() && !found) {
            // Prepare next level
            Set<String> nextLevel = new HashSet<>();
            // Mark current level nodes as visited to avoid revisiting in the same level
            visited.addAll(currentLevel);

            // Traverse all words in current BFS level
            for (String word : currentLevel) {
                char[] chs = word.toCharArray();

                // Try changing every character to all letters from 'a' to 'z'
                for (int i = 0; i < chs.length; i++) {
                    char original = chs[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chs[i] = c;
                        String nextWord = new String(chs);

                        // If next word is not in wordSet or already visited, skip it
                        if (!wordSet.contains(nextWord) || visited.contains(nextWord)) continue;

                        // If nextWord is not yet in parents map, add it with an empty list
                        if (!parents.containsKey(nextWord)) {
                            parents.put(nextWord, new ArrayList<>());
                        }

                        // Add current word as a parent of nextWord
                        parents.get(nextWord).add(word);

                        // If we reach the endWord, set found = true
                        if (nextWord.equals(endWord)) found = true;

                        // Add this word to the next BFS level
                        nextLevel.add(nextWord);
                    }

                    // Restore the character before moving to the next position
                    chs[i] = original;
                }
            }

            // Move to the next level
            currentLevel = nextLevel;
        }

        // Result to store all shortest transformation sequences
        List<List<String>> res = new ArrayList<>();

        // If a path is found, start backtracking from endWord to beginWord
        if (found) {
            List<String> path = new LinkedList<>();
            backtrack(endWord, beginWord, parents, path, res);
        }

        return res;
    }

    // Helper function to perform DFS-style backtracking to build paths
    private void backtrack(String word, String beginWord, Map<String, List<String>> parents,
                           List<String> path, List<List<String>> res) {
        // Base case: If we reach the beginWord, add the complete path to result
        if (word.equals(beginWord)) {
            path.add(0, word); // Add at beginning since we are building path backwards
            res.add(new ArrayList<>(path)); // Add a copy of current path to result
            path.remove(0); // Backtrack
            return;
        }

        // If no parent exists for the word, return (dead end)
        if (!parents.containsKey(word)) return;

        // Add current word to front of path
        path.add(0, word);

        // Recursively call backtrack for all parents of current word
        for (String parent : parents.get(word)) {
            backtrack(parent, beginWord, parents, path, res);
        }

        // Backtrack by removing current word
        path.remove(0);
    }
}
