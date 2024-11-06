class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean swapped;
        
        for (int pass = 0; pass < n - 1; pass++) {
            swapped = false;
            
            for (int i = 0; i < n - pass - 1; i++) {
                int bits1 = countBits(nums[i]);
                int bits2 = countBits(nums[i + 1]);
                
                // Swap if they have the same set bits and are out of order
                if (bits1 == bits2 && nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapped = true;
                }
            }
            
            // Early exit if no swaps were made in this pass
            if (!swapped) break;
        }
        
        // Final check to see if the array is sorted
        return isSorted(nums);
    }
    
    // Count number of set bits in a number
    private int countBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    
    // Check if the array is sorted in ascending order
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}
