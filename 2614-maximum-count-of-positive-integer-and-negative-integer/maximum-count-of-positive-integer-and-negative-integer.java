class Solution {
    public int maximumCount(int[] nums) {
        if(nums[0]==0 && nums[nums.length-1]==0){
            return 0;
        }
        int left = 0, right = nums.length-1;
        int zeroPosition = -1;
        boolean isZero = false;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==0){
                zeroPosition = mid;
                isZero = true;
                right=mid-1;
            }
            else if(nums[mid]<0){
                if((mid+1)<nums.length && nums[mid+1]>0){
                    zeroPosition = mid;
                }
                left = mid+1;
            }
            else{
                right=mid-1;
            }
        }
        System.out.println(zeroPosition);
        int neg=0,pos=0;
        if(!isZero){
            neg = zeroPosition+1;
            pos = nums.length-neg;
            
        }
        else{
            neg = zeroPosition;
            while(zeroPosition<nums.length && nums[zeroPosition]==0){
                zeroPosition++;
            }
            pos = nums.length-zeroPosition;
        }
        
        
        
        System.out.print(neg +" n-p "+ pos);
        return (int)Math.max(neg,pos);
    }
}