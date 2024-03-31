class Solution {
    
    public int countOfSubArrayWithAtMostKDistinct(int[] nums, int k){
        int n = nums.length, left = 0 , right = 0, count = 0;
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        for(; right<n; right++){
           numFreq.compute(nums[right], (key, value) -> (value==null) ? 1 : value+1);

            while(numFreq.size()>k){
                numFreq.put(nums[left], numFreq.get(nums[left])-1);
                if(numFreq.get(nums[left]) == 0) numFreq.remove(nums[left]);
                left++;
            }
            count+=(right-left+1);
        }
        return count;
    }


    public int subarraysWithKDistinct(int[] nums, int k) {
        return countOfSubArrayWithAtMostKDistinct(nums,k)-countOfSubArrayWithAtMostKDistinct(nums,k-1);
    }
}