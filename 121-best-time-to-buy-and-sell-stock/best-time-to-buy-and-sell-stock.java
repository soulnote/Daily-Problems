class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int mprofit=0;
        for(int i=0;i<prices.length;i++){
            min = Math.min(prices[i],min);
            mprofit = Math.max(mprofit,prices[i]-min);
        } 
        return mprofit;
    }
}