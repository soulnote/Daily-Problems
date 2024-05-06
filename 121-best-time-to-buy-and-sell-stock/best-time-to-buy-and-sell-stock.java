class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)return 0;
        int minbuy = prices[0];
        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]-minbuy>maxProfit){
                maxProfit = prices[i]-minbuy;
            }
            minbuy = Math.min(minbuy, prices[i]);
        }
        return maxProfit;
    }
}