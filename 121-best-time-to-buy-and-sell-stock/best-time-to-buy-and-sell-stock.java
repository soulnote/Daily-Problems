class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currLow = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>currLow){
                int profit = prices[i]-currLow;
                maxProfit = Math.max(maxProfit, profit);
            }
            if(prices[i]<currLow){
                currLow = prices[i];
            }
        }
        return maxProfit;
    }
}