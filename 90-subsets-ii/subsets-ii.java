class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,list,ans);
        return new ArrayList<>(ans); 
    }
    public void solve(int idx,int[]nums,List<Integer>list, HashSet<List<Integer>> ans){
        if(idx==nums.length){
            if(!ans.contains(list)){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[idx]);
        solve(idx+1,nums,list,ans);
        list.remove(list.size()-1);
        solve(idx+1,nums,list,ans);
    }

}