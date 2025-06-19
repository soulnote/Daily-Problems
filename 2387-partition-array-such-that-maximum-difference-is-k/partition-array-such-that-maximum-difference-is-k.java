class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int j =i+1;
            System.out.print(nums[i]);
            while(j<nums.length && (nums[j]-nums[i]<=k)){
                // System.out.print(nums[j]);
                j++;
            }
            count++;
            i = j-1;
           
            // System.out.println();
            // count++;
        }
        return count;
    }
}