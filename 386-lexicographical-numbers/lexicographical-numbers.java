class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curr = 1;
        
        for (int i = 1; i <= n; i++) {
            result.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;  // go deeper
            } else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;  // backtrack
                }
                curr += 1;  // move to next sibling
            }
        }
        
        return result;
    }
}
