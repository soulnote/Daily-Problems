class Solution {
     List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<Integer> curr = new ArrayList<>();
        solve(0,candidates,curr,target);
        return res;
    }
    void solve(int idx,int[]nums,List<Integer> curr,int target){
        if(idx>=nums.length || target<0)
            return ;
        if(target==0){
            res.add(new ArrayList<>(curr));
            return ;
        }
        
        curr.add(nums[idx]);
        solve(idx,nums,curr,target-nums[idx]);
        curr.remove(curr.size()-1);
        solve(idx+1,nums,curr,target);
    }
}