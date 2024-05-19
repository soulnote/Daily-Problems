class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int digitCount = String.valueOf(nums[0]).length();
        
        int[][] countDigitAtPlace = new int[digitCount][10];
        
        for(int i = 0 ; i < n ; i++){
            int k = nums[i];
            int place = 0;
            while(k>0){
                int rem = k%10;
                countDigitAtPlace[place][rem]++;
                place++;
                k/=10;
            }
        }
        
        long res = 0;
        
        for(int place = 0 ; place < digitCount; place++){
            for(int i = 0 ; i <10; i++){
                for(int j = i+1; j<10; j++){
                    res+=(countDigitAtPlace[place][i]*countDigitAtPlace[place][j]);
                }
            }
        }
        
        return res;
        
    }
}