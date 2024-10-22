class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxEat = 0;
        for(int num : piles){
            maxEat = Math.max(num, maxEat);
        }
        int left  = 1,right =maxEat;
        int ans = 0;
        while(left<=right){
            int hRemaining = h;
            int idx = 0;
            int minEat = left+(right-left)/2;
            while(idx<piles.length){
                int banana = piles[idx];
                hRemaining-= (banana/minEat);
                banana%=minEat;
                if(banana>0)hRemaining--;
                idx++;
            }
            if(hRemaining>=0){
                ans = minEat;
                right = minEat-1;
            }
            else{
                left = minEat+1;
            }
            
        }
        return ans;
    }
}