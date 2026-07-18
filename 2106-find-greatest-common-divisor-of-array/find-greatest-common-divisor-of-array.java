class Solution {
    public int findGCD(int[] nums) {
        int max = 0;
        int min = 1000;
        for(int num : nums){
            if(num>max)max = num;
            if(num<min)min = num;
        }
        while(max%min!=0){
            int rem = max%min;
            max = min;
            min = rem;
        }
        return min;
    }
}