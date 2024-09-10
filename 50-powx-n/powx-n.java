class Solution {
    public double myPow(double x, int n) {
        // Handle edge case where n is Integer.MIN_VALUE safely
        long newn = n;  // Use long to handle large negative n
        if (newn < 0) {
            x = 1 / x;   // Invert x when n is negative
            newn = -newn; // Make n positive
        }

        double ans = 1.0;
        while (newn > 0) {
            // If the current power is odd, multiply ans by x
            if ((newn & 1) == 1) {  // Bitwise check for odd numbers
                ans *= x;
            }
            x *= x;  // Square x
            newn >>= 1;  // Right shift newn (equivalent to dividing by 2)
        }

        return ans;
    }
}
