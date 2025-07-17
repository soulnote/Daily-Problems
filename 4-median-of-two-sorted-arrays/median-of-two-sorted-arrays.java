class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;

        int i = 0;
        int j = 0;
        int count = 0;
        int prevElement = 0;
        int currentElement = 0;

        int targetCount = (totalLength / 2) + 1;

        while (count < targetCount) {
            prevElement = currentElement;

            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                currentElement = nums1[i];
                i++;
            } else {
                currentElement = nums2[j];
                j++;
            }
            count++;
        }

        if (totalLength % 2 == 1) {
            return (double) currentElement;
        } else {
            return (double) (prevElement + currentElement) / 2.0;
        }
    }
}