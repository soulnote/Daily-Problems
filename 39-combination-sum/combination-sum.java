class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, ans,new ArrayList<>());
        return ans;
    }
    public void solve(int idx, int[]nums, int target, List<List<Integer>> ans, List<Integer> list){
        if(idx>=nums.length || target<0)return;
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        solve(idx, nums, target-nums[idx], ans, list);
        list.remove(list.size()-1);
        solve(idx+1, nums, target, ans, list);
    }
}