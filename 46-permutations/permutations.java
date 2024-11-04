class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new LinkedHashSet<>(), nums);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, Set<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if(!path.contains(num)) {
                path.add(num);
                dfs(res, path, nums);
                path.remove(num);
            }
        }
    }
}