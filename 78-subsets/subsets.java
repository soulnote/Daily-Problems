class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int idx, int[] nums, List<Integer> path, List<List<Integer>> ans) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(path)); // Add a copy of the current path
            return;
        }

        // 1. Include current element
        path.add(nums[idx]);
        backtrack(idx + 1, nums, path, ans);

        // 2. Exclude current element (Backtrack)
        path.remove(path.size() - 1); // Undo the choice
        backtrack(idx + 1, nums, path, ans);
    }
}
