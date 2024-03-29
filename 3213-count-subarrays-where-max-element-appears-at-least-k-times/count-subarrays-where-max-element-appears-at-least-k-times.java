class Solution {
    public long countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        int start =0,end=0,count=0;
        long ans=0;
        while(end<n){
            if(nums[end]==max)
            count++;
            while(count>=k){
            ans = ans +(n-end);
            if(nums[start]== max)
            count--;
            start++;
        }
         end++;
        }
      return ans;
    }
}   