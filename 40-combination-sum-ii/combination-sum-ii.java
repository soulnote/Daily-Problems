class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, new ArrayList<>(),ans);
        return ans;
    }
    public void solve(int idx, int[]candidates, int target, List<Integer> list, List<List<Integer>> ans){
       
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1])continue;
            if(candidates[i]>target)break;
            list.add(candidates[i]);
            solve(i+1,candidates,target-candidates[i],list,ans);
            list.remove(list.size()-1);
        }
        
    }
}