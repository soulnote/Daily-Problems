class Solution {
    public String[] shortestSubstrings(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        // Step 1: Count all substrings across all strings
        for (String s : arr) {
            generateSubstrings(s, set);
            for(String str : set){
                map.put(str, map.getOrDefault(str, 0)+1);
            }
            set.clear();
        }

        // Step 2: Find shortest unique substring for each string
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            int n = str.length();
            String shortest = null;

            for (int len = 1; len <= n; len++) { // start from length 1
                for (int start = 0; start + len <= n; start++) {
                    String sub = str.substring(start, start + len);
                    if (map.get(sub) == 1) { // unique substring
                        if (shortest == null || sub.compareTo(shortest) < 0) {
                            shortest = sub;
                        }
                    }
                }
                if (shortest != null) break; // found shortest, no need for longer substrings
            }

            ans[i] = (shortest != null) ? shortest : "";
        }

        return ans;
    }

    // Generate all substrings and count them
    public void generateSubstrings(String str, HashSet<String> set) {
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = str.substring(i, j);
                set.add(sub);
            }
        }
    }
}