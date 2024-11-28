class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        backtrack(res, new ArrayList<>(), nums, map);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, Map<Integer, Integer> map) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int key : new ArrayList<>(map.keySet())) {  // Create a copy of the key set to avoid modification errors
            path.add(key);
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                map.remove(key);
            }
            backtrack(res, path, nums, map);
            map.put(key, map.getOrDefault(key, 0) + 1);
            path.remove(path.size() - 1);
        }
    }
}
