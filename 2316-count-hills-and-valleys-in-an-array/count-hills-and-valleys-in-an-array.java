class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        List<Integer> distinctList = new ArrayList<>();
        int idx = 0;
        while(idx<n){
            int curr = nums[idx];
            distinctList.add(curr);
            while(idx<n && curr==nums[idx]){
                idx++;
            }
        }
        int total  =0;
        for(int i = 1;i<distinctList.size()-1;i++){
            
            if(distinctList.get(i)>distinctList.get(i-1) && distinctList.get(i)>distinctList.get(i+1))total++;
            if(distinctList.get(i)<distinctList.get(i-1) && distinctList.get(i)<distinctList.get(i+1))total++;
            
        }
        return total;

    }
}