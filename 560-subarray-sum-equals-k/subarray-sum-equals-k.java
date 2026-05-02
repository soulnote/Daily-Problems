class Solution {
    public int subarraySum(int[] nums, int k) {
        int[]prefixsum = new int[nums.length];
        int currsum = 0, result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums){
            currsum += num;
            if(map.containsKey(currsum - k)){
                result+= map.get(currsum - k);
            }
            map.put(currsum, map.getOrDefault(currsum, 0)+1);
        }
        return result;
    }
}