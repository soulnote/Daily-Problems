class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int totalSubarrays = 0, remainder=0;
        for(int i=0;i<nums.length;i++){
            remainder = (remainder+nums[i])%k;
            if(remainder<0){
                remainder+=k;
            }
            if(map.containsKey(remainder)){
                totalSubarrays+=map.get(remainder);
                map.put(remainder,map.get(remainder)+1);
            }
            else{
                map.put(remainder, 1);
            }
        }
        return totalSubarrays;
    }
}