class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>(0);
        solve(0,nums,list);
        return ans;
    }
    public void solve(int idx, int[]nums,List<Integer>list){
        if(idx==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        solve(idx+1, nums , list);
        ArrayList<Integer> nlist = new ArrayList<>(list);
        nlist.add(nums[idx]);
        solve(idx+1, nums,nlist);
    }
}