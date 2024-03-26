class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(set.contains(i)){
                ans = i+1;
            }
            else{
                ans = i;
                break;
            }
        }
        return ans;
    }
}