class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();//<nummber, index>
        for(int i=nums.length-1;i>=0;i--){
            int key = nums[i];
            int reversed = reverse(key);
            if(map.containsKey(reversed)){
                int dist = map.get(reversed)-i;
                min = Math.min(dist, min);
            }
            map.put(key, i);
        }
        if(min == Integer.MAX_VALUE)return -1;
        return min;
    }
    public int reverse(int n){
        int rev = 0;
        while(n!=0){
            int digit = n%10;
            rev = rev*10 + digit;
            n = n/10;
        }
        return rev;
    }
}