class Solution {
    public long countLessEqual(int[] nums1, int[] nums2, long x) {
        int n = nums1.length, m = nums2.length;
        long count = 0;

        for (int a : nums1) {
            if (a == 0) {
                if (x >= 0) count += m;
            } else if (a > 0) {
                int low = 0, high = m - 1, res = -1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if ((long)a * nums2[mid] <= x) {
                        res = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                count += (res + 1);
            } else {
                int low = 0, high = m - 1, res = m;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if ((long)a * nums2[mid] <= x) {
                        res = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                count += (m - res);
            }
        }
        return count;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L, high = 10000000000L, ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (countLessEqual(nums1, nums2, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}