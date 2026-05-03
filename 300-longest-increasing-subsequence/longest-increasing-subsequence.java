class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            int low = 0, high = tails.size();

            // Binary search: pehla index jahan tails[mid] >= num
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (tails.get(mid) < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            if (low == tails.size()) {
                tails.add(num); // Sabse bada hai, end me add
            } else {
                tails.set(low, num); // Replace karo
            }
        }
        return tails.size();
    }
}
