class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new LinkedHashSet<>(), nums);
        return ret;
    }
    
    private void dfs(List<List<Integer>> ret, Set<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            if (path.add(num)) {
                dfs(ret, path, nums);
                path.remove(num);
            }
        }
    }
}