import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // Step 1: Sort the array
        List<int[]> result = new ArrayList<>();

        // Step 2: Traverse in chunks of 3
        for (int i = 0; i < n; i += 3) {
            int min = nums[i];
            int mid = nums[i + 1];
            int max = nums[i + 2];

            if (max - min > k) {
                return new int[0][]; // Not possible
            }

            result.add(new int[]{min, mid, max});
        }

        // Step 3: Convert to 2D array
        return result.toArray(new int[result.size()][]);
    }
}
