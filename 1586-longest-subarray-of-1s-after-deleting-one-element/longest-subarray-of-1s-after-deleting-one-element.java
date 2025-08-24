class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int zeroPresent = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int zeros = 0;
                while(i<n && nums[i]==0){
                    zeros++;
                    i++;
                }
                zeroPresent++;
                i--;
                if(zeros>1)list.add(0);
            }
            else{
                int ones = 0;
                while(i<n && nums[i]==1){
                    ones++;
                    i++;
                }
                i--;
                list.add(ones);
            }
        }
        if(list.size()==0)return 0;
        int maxones = list.get(0);
        for(int i=1;i<list.size();i++){
            int currmax = list.get(i)+list.get(i-1);
            maxones = Math.max(currmax, maxones);
        }

        if(zeroPresent ==0)maxones--;
        return maxones;

    }
}