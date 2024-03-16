class Solution {
    public int findMaxLength(int[] nums) {
        int status=0;
        int last = nums[0];
        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            status+= nums[i]==0?-1:1;
            if(status==0){
                max = i+1;
            }
            else if(map.containsKey(status)){
                max = Math.max(max,i-map.get(status));
            }
            else map.put(status, i);
        }
        return max;
    }
}