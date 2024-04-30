class Solution {
    public int minOperations(int[] nums, int k) {
        
        int flipCount = 0;
        int xorSum = 0;
        for(int data: nums){
            xorSum ^= data;
        }

        for(int i=0; i<32; i++){
            int mask = 1<<i;
            
            if((xorSum & mask) != (k & mask)){
                flipCount++;
            }
        }

        return flipCount;
    }
}