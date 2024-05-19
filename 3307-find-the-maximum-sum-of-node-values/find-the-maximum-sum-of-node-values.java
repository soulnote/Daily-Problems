class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0, count = 0, minDiff = Integer.MAX_VALUE;
        for (long num : nums){
            sum += Math.max(num ^ k, num);
            count += ((num ^ k) > num) ? 1 : 0;
            minDiff = Math.min(minDiff, Math.abs(num - (num ^ k)));
        }
        return sum - (count % 2 == 1 ? minDiff : 0);
    }
}