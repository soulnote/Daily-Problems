import java.util.*;

class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            total += getWaviness(num);
        }

        return total;
    }

    private int getWaviness(int num) {
        String s = String.valueOf(num);

        if (s.length() < 3) {
            return 0;
        }

        int waviness = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            int left = s.charAt(i - 1) - '0';
            int mid = s.charAt(i) - '0';
            int right = s.charAt(i + 1) - '0';

            // Peak
            if (mid > left && mid > right) {
                waviness++;
            }

            // Valley
            else if (mid < left && mid < right) {
                waviness++;
            }
        }

        return waviness;
    }
}