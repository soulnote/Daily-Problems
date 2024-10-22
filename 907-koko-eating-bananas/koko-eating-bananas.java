class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxEat = 0;
        for (int num : piles) {
            maxEat = Math.max(num, maxEat);
        }

        int left = 1, right = maxEat;
        int ans = maxEat;
        while (left <= right) {
            int hRemaining = h;
            int minEat = left + (right - left) / 2;

            for (int pile : piles) {
                hRemaining -= Math.ceil((double) pile / minEat);
            }

            if (hRemaining >= 0) {
                ans = minEat;
                right = minEat - 1;
            } else {
                left = minEat + 1;
            }
        }
        return ans;
    }
}
