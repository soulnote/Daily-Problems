class Solution {
    public boolean canJump(int[] nums) {
        int[] visited = new int[nums.length];
        Arrays.fill(visited, -1);
        return solve(nums, 0, visited);
    }

    public boolean solve(int[] nums, int idx, int[] visited) {
        if (idx >= nums.length) return false;
        if (idx == nums.length - 1) return true;

        if (visited[idx] != -1) {
            return visited[idx] == 1;
        }

        int maxJumps = nums[idx];

        for (int i = 1; i <= maxJumps; i++) {
            if (solve(nums, idx + i, visited)) {
                visited[idx] = 1;
                return true;
            }
        }

        visited[idx] = 0;
        return false;
    }
}