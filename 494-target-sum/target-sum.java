class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        return totalWays(0, nums, target, 0, map);
    }
    public int totalWays(int idx, int[]nums, int target, int amount, HashMap<String, Integer> map){
        if(target==amount && idx == nums.length)return 1;
        if(idx>=nums.length)return 0;
        String key = idx + "-" + amount;
        if(map.containsKey(key))return map.get(key);
        int plus = totalWays(idx+1, nums, target, amount+nums[idx], map);
        int minus = totalWays(idx+1, nums, target, amount-nums[idx], map);

        map.put(key,plus+minus);
        return map.get(key);
    }
}