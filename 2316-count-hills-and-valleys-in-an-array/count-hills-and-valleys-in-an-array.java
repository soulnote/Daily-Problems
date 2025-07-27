class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }

        int total = 0;
        int previousNonEqual = nums[0]; 

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == previousNonEqual) {
                continue;
            }

            int nextNonEqual = -1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] != nums[i]) {
                    nextNonEqual = nums[j];
                    break;
                }
            }

            if (nextNonEqual != -1) {
                if (nums[i] > previousNonEqual && nums[i] > nextNonEqual) {
                    total++;
                } 
                else if (nums[i] < previousNonEqual && nums[i] < nextNonEqual) {
                    total++;
                }
            }
            
            previousNonEqual = nums[i]; 
        }

        return total;
    }
}