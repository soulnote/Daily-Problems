class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = -1;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(Math.abs(nums[i]))){
                if(nums[map.get(Math.abs(nums[i]))]*nums[i]<0){
                    max = Math.max(max, Math.abs(nums[i]));
                }
            }
            map.put(Math.abs(nums[i]), i);
        }
        return max;
    }
}