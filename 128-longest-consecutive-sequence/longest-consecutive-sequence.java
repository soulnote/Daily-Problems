class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans =0;
        for(int val:nums){
            if(!set.contains(val-1)){
                int count=1;
                while(set.contains(val+1)){
                    count++;
                    val++;
                }
                ans = Math.max(count,ans);
            }
        }
        return ans;
    }
}