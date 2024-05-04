class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1)return 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        return profit(prices, 0, true, map);
    }
    public int profit(int[]prices, int idx, boolean buying, HashMap<String, Integer> map){
        if(idx>= prices.length)return 0;
        String key = idx + "-" + buying;
        if(map.containsKey(key)) return map.get(key);
        //not paticipating on that day
        int notParticipated =  profit(prices, idx+1, buying, map);
        int participated = Integer.MIN_VALUE;
        if(buying){
            participated = profit(prices, idx+1, !buying, map) - prices[idx];
        }
        else{
            participated = profit(prices, idx+2, !buying, map) + prices[idx];
        }

        map.put(key, Math.max(participated, notParticipated));
        return map.get(key);
    }
}