class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1,high =Integer.MIN_VALUE;
        
        for(int num: piles){
            high = Math.max(num,high);
        }
        int n= piles.length;
        int k = high;
        while(low<=high){
            int mid = (low + high)/2;
            int timetoeat = checkTime(mid,piles);

            if(timetoeat<=h){
                high = mid-1;
                k = Math.min(mid,k);
            }
            else{
                low = mid+1;
            }
        }
        return k;
    }
    public int checkTime(int middle,int[]piles){
        int hourSpent = 0;
        for (int pile : piles) {
            hourSpent += Math.ceil((double) pile / middle);
        }
        return hourSpent;
    }
}