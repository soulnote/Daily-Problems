import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness); 
        int n = happiness.length;
        long maxSum = 0;
        int count=0;
        for (int i = n - 1; i >= 0; i--) {
            if(happiness[i]-count<0 || k<=0)break;
            maxSum += happiness[i]-count; 
            k--;
            count++;
        }
        
        return maxSum;
    }
}
