class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates,list,target,0);
        return ans;
    }
    public void solve(int idx, int[]arr, List<Integer> list, int target,int sum){
        if(sum>target || idx>=arr.length)return;
        if(target==sum){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        list.add(arr[idx]);
        solve(idx,arr,list,target,sum+arr[idx]);
        list.remove(list.size()-1);
    
        solve(idx+1,arr,list,target,sum);
    }
}