class Solution {
    public long distributeCandies(int n, int limit) {
        long count = 0;

        for (int a = 0; a <= Math.min(n, limit); a++) {
            int minB = Math.max(0, n - a - limit);
            int maxB = Math.min(limit, n - a);
            if (minB <= maxB) {
                count += (maxB - minB + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.distributeCandies(5, 2)); // Output: 6
    }
}
