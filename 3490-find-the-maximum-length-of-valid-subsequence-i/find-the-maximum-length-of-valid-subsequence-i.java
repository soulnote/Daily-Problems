class Solution {
    public int maximumLength(int[] nums) {
        int odds=0, evens = 0, oddeven=0, evenodd = 0;
        int preOddeven = 0, preEvenodd = 1;
        int idx = 0;
        while(idx<nums.length){
            if(nums[idx]%2==0){
                evens++;
                if(preOddeven==1){
                    oddeven++;
                    preOddeven = 0;
                }
                if(preEvenodd==1){
                    evenodd++;
                    preEvenodd = 0;
                }
            }
            if(nums[idx]%2==1){
                odds++;
                if(preOddeven==0){
                    oddeven++;
                    preOddeven=1;
                }
                if(preEvenodd==0){
                    evenodd++;
                    preEvenodd=1;
                }
            }
            idx++;
        }
        int ans = Math.max(Math.max(odds, evens), Math.max(evenodd, oddeven));
        return ans;
    }
}