class Solution {
    public int minOrAfterOperations(int[] nums, int k) {
        int mask = 0;
        // highest bit (29) se lowest bit (0) tak check karte hain
        for (int bit = 29; bit >= 0; bit--) {
            mask |= (1 << bit); // ye bit ko mask me include karo
            if (operationsNeeded(nums, mask) > k) {
                // agar zyada operations chahiye to ye bit hata do
                mask ^= (1 << bit);
            }
        }
        // final OR wahi bits honge jo remove nahi ho paye
        return ((1 << 30) - 1) ^ mask;
    }

    private int operationsNeeded(int[] nums, int mask) {
        int ops = 0, n = nums.length;
        int i = 0;

        while (i < n) {
            // agar current number ke bits mask se overlap karte hain
            if ((nums[i] & mask) != 0) {
                int cur = nums[i];
                // merge karte jao jab tak overlap clear na ho
                while (i + 1 < n && ((cur & mask) != 0)) {
                    cur &= nums[++i];
                    ops++;
                }
                // agar abhi bhi overlap hai, ek extra operation chahiye
                if ((cur & mask) != 0) ops++;
            }
            i++;
        }
        return ops;
    }
}
