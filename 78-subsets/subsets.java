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
        
        System.out.println(list);
        solve(idx+1, nums , list);
        list.add(nums[idx]);
        solve(idx+1, nums,list);
        list.remove(list.size()-1);
    }
}