class Solution {
    public int trap(int[] height) {
        // Step 1: Base condition agar array empty ya null hai
        if (height == null || height.length == 0) {
            return 0;
        }

        // Step 2: Two pointers and variables initialization
        int left = 0;  // left pointer
        int right = height.length - 1;  // right pointer
        int left_max = 0;  // left ka ab tak ka maximum height
        int right_max = 0;  // right ka ab tak ka maximum height
        int water = 0;  // total trapped water ko store karne ke liye

        // Step 3: Process till left pointer is less than right pointer
        while (left < right) {
            // Step 4: Process left side
            if (height[left] < height[right]) {
                // Left side me paani trap hoga, agar left_max bada hai to paani calculate karo
                if (height[left] >= left_max) {
                    left_max = height[left];  // Update left_max
                } else {
                    water += (left_max - height[left]);  // Trap water
                }
                left++;  // Move left pointer ahead
            } 
            // Step 5: Process right side
            else {
                // Right side me paani trap hoga, agar right_max bada hai to paani calculate karo
                if (height[right] >= right_max) {
                    right_max = height[right];  // Update right_max
                } else {
                    water += (right_max - height[right]);  // Trap water
                }
                right--;  // Move right pointer backward
            }
        }

        // Step 6: Return total water trapped
        return water;
    }
}
